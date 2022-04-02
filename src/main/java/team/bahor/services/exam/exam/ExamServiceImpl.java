package team.bahor.services.exam.exam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import team.bahor.dto.exam.exam.*;
import team.bahor.dto.exam.examQuestion.ExamQuestionDto;
import team.bahor.dto.exam.examQuestionGeneration.ExamQuestionGenerationCreateDto;
import team.bahor.entity.exam.Exam;
import team.bahor.entity.exam.ExamQuestionUser;
import team.bahor.entity.exam.ExamUser;
import team.bahor.exeptions.exam.FinishDtoException;
import team.bahor.exeptions.exam.NotFoundExamException;
import team.bahor.exeptions.exam.SolveBadCredentialException;
import team.bahor.mappers.exam.ExamMapper;
import team.bahor.repositories.exam.ExamQuestionUserRepository;
import team.bahor.repositories.exam.ExamRepository;
import team.bahor.repositories.exam.ExamUserRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.services.exam.examQuestion.ExamQuestionServiceImpl;
import team.bahor.services.exam.examQuestionGeneration.ExamQuestionGenerationServiceImpl;
import team.bahor.utils.Utils;
import team.bahor.validators.exam.ExamValidator;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ExamServiceImpl extends AbstractService<
        ExamRepository,
        ExamMapper,
        ExamValidator
        > implements ExamService {


    private final ExamQuestionGenerationServiceImpl examQuestionGenerationService;
    private final ExamQuestionUserRepository examQuestionUserRepository;
    private final ExamQuestionServiceImpl examQuestionService;
    private final ExamUserRepository examUserRepository;

    public ExamServiceImpl(ExamMapper mapper, @Lazy ExamValidator validator, ExamRepository repository, ExamQuestionGenerationServiceImpl examQuestionGenerationService, ExamQuestionUserRepository examQuestionUserRepository, ExamQuestionServiceImpl examQuestionService, ExamUserRepository examUserRepository) {
        super(mapper, validator, repository);
        this.examQuestionGenerationService = examQuestionGenerationService;
        this.examQuestionUserRepository = examQuestionUserRepository;
        this.examQuestionService = examQuestionService;
        this.examUserRepository = examUserRepository;
    }

    @Override
    public String create(ExamCreateDtoBegin createDto) {
        validator.validOnCreate(createDto);
        Exam exam = mapper.fromCreateDto(createDto);
        exam.setStatus((short) 300);
        exam.setId(UUID.randomUUID().toString());
        return repository.save(exam).getId();
    }

    @Override
    public void delete(String id) {
        repository.deleted(id);
    }

    @Override
    public void update(ExamUpdateDto updateDto) {

    }

    @Override
    public ExamDto get(String id) {
        //todo examdto ichiga couserseTitle qo'sh
        Optional<Exam> byIdAndDeletedFalse = repository.findByIdAndDeletedFalse(id);
        if (byIdAndDeletedFalse.isEmpty()) {
            throw new NotFoundExamException("Not found Exam");
        }
        ExamDto examDto = mapper.toDto(byIdAndDeletedFalse.get());
        Map<String, Integer> questionCount = new HashMap<>();
        examQuestionGenerationService.getAllByExamId(id).forEach(examQuestionGenerationDto -> questionCount.put(examQuestionGenerationDto.getMark(), examQuestionGenerationDto.getCount()));
        examDto.setQuestionCounts(questionCount);
        return examDto;
    }

    @Override
    public List<ExamDto> getAll() {
        return repository.findAllByDeletedFalse().parallelStream().map(exam -> {
            ExamDto examDto = mapper.toDto(exam);
            Map<String, Integer> questionCount = new HashMap<>();
            examQuestionGenerationService.getAllByExamId(exam.getId()).forEach(examQuestionGenerationDto ->
                    questionCount.put(examQuestionGenerationDto.getMark(), examQuestionGenerationDto.getCount()));
            examDto.setQuestionCounts(questionCount);
            return examDto;
        }).toList();
    }

    public String create(ExamCreateDtoEnd dto) {
        validator.createEnd(dto);
        ExamDto examDto = this.get(dto.getId());
        examDto.setDuration(dto.getDuration());
        AtomicInteger questionCount = new AtomicInteger();
        AtomicInteger mark = new AtomicInteger();
        dto.getQuestionCounts().forEach((k, v) -> {
            questionCount.addAndGet(Integer.parseInt(k));
            mark.addAndGet(Integer.parseInt(k) * v);
            examQuestionGenerationService.create(new ExamQuestionGenerationCreateDto(dto.getId(), v, Integer.parseInt(k)));
        });
        //todo save qilish uchun thread pool yarat
        examDto.setQuestionCount(questionCount.get());
        examDto.setMaxMark(mark.get());
        repository.update(examDto);
        return dto.getId();
    }

    public void block(String id) {
        repository.block(id);
    }

    public String createExamUser(String examId) {
        AtomicInteger count = new AtomicInteger(1);
        System.out.println("(repository.getByIdForDuration(examId) / 1000) = " + (repository.getByIdForDuration(examId)));
        Exam exam = repository.getByIdAndDeletedIsFalse(examId);
        LocalDateTime finishingTime = LocalDateTime.now().plusSeconds(exam.getDuration() / 1000);
        ExamUser examUser = new ExamUser();
        String examUserId = UUID.randomUUID().toString();
        examUser.setId(examUserId);
        examUser.setExamId(examId);
        examUser.setUserId(Utils.getSessionId());
        examUser.setFinishingTime(finishingTime);
        examUser.setMark(exam.getMaxMark());
        examUserRepository.save(examUser);
        examQuestionGenerationService.getAllByExamId(examId).parallelStream()
                .forEach(examQuestionGenerationDto ->
                        examQuestionService.getByExamId(examId, examQuestionGenerationDto.getMark(), examQuestionGenerationDto.getCount())
                                .parallelStream().forEach(examQuestionId -> {
                                    ExamQuestionUser examQuestionUser = new ExamQuestionUser();
                                    examQuestionUser.setId(UUID.randomUUID().toString());
                                    examQuestionUser.setExamUserId(examUserId);
                                    examQuestionUser.setOrderQuestion(count.getAndIncrement());
                                    examQuestionUser.setExamQuestionId(examQuestionId);
                                    examQuestionUserRepository.save(examQuestionUser);
                                }));
        System.out.println("Utils.getSessionId() = " + Utils.getSessionId());
        return examUserId;
    }


    public InformationForCreateExamUser informationForCreateExamUser(String examId) {
        InformationForCreateExamUser informationForCreateExamUser = new InformationForCreateExamUser();
        informationForCreateExamUser.setExamId(examId);
        informationForCreateExamUser.setQuestionCounts(examQuestionService.informationForCreateExamUser(examId));
        informationForCreateExamUser.setExamTitle(this.get(examId).getTitle());
        informationForCreateExamUser.setCourseTitle(this.get(examId).getCourseTitle());
        return informationForCreateExamUser;
    }

    public ExamSolveDto solve(ExamSolveDto exam) {
        try {
            ExamSolveDto examSolveDto = new ExamSolveDto();
            Exam examByExamUserId = repository.getByExamUserId(exam.getExamUserId());
            ExamUser examUser = examUserRepository.getById(exam.getExamUserId());
            if (examUser.getFinishingTime().isAfter(LocalDateTime.now())) {
                this.finish(exam.getExamUserId());
            }
            if (Objects.isNull(exam.getNextOrder())) {
                exam.setNextOrder(1);

            }
            //todo thread pool yaratsang shuni methodni berib yubor
            if (Objects.nonNull(exam.getOrder())) {
                this.saveExamSolveDto(exam);
            }
            examQuestionDto(exam, examSolveDto, examByExamUserId);
            return examSolveDto;
        } catch (Exception ex) {
            throw new SolveBadCredentialException("Javob jonatishdingiz");
        }

    }

    private void examQuestionDto(ExamSolveDto exam, ExamSolveDto examSolveDto, Exam examByExamUserId) {
        ExamQuestionDto examQuestionDto = examQuestionService.getByExamUserIdAndOrder(exam.getExamUserId(), exam.getNextOrder());
        if (Objects.isNull(examQuestionDto.getExamId())) {
            examQuestionDto = examQuestionService.getByExamUserIdAndOrder(exam.getExamUserId(), 1);
        }
        examSolveDto.setExamUserId(exam.getExamUserId());
        //todo exam title qolib ketdi
        examSolveDto.setExamTitle(examByExamUserId.getTitle());
        examSolveDto.setFinishingTime(examUserRepository.findByExamUserIdForFinishingTime(exam.getExamUserId()).toLocalDateTime());
        examSolveDto.setOrder(exam.getNextOrder());
        examSolveDto.setQuestionDto(examQuestionDto);
    }

    private void saveExamSolveDto(ExamSolveDto exam) {
        examQuestionUserRepository.saveExamSolveDto(exam.getExamUserId(), exam.getOrder(), exam.getMarkedAnswerId());
    }

    public FinishDto finish(String examUserId) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(repository.finish(examUserId), FinishDto.class);
        } catch (JsonProcessingException e) {
            throw new FinishDtoException("Finish Dto Exception");
        }
    }

    public boolean isMakeExam(String courseId) {
        return repository.isMakeExam(courseId);
    }

    public boolean isCanCreateBegin(String sessionId, String couseId) {
        return repository.isCanCreateBegin(sessionId,couseId);
    }

    public boolean isCanCreateEnd(String sessionId, String id) {
        return repository.isCanCreateEnd(sessionId,id);
    }

    public boolean isThereCourse(String courseId) {
        return repository.isThereCourse(courseId);
    }
}

