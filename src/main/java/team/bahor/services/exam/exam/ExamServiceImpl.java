package team.bahor.services.exam.exam;

import org.springframework.stereotype.Service;
import team.bahor.dto.exam.exam.ExamCreateDtoBegin;
import team.bahor.dto.exam.exam.ExamCreateDtoEnd;
import team.bahor.dto.exam.exam.ExamDto;
import team.bahor.dto.exam.exam.ExamUpdateDto;
import team.bahor.dto.exam.examQuestionGeneration.ExamQuestionGenerationCreateDto;
import team.bahor.entity.exam.Exam;
import team.bahor.exeptions.exam.NotFoundExamException;
import team.bahor.mappers.exam.ExamMapper;
import team.bahor.repositories.exam.ExamRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.services.exam.exam.ExamService;
import team.bahor.services.exam.examQuestionGeneration.ExamQuestionGenerationServiceImpl;
import team.bahor.validators.exam.ExamValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ExamServiceImpl extends AbstractService<
        ExamRepository,
        ExamMapper,
        ExamValidator
        > implements ExamService {

    private final ExamQuestionGenerationServiceImpl examQuestionGenerationService;

    public ExamServiceImpl(ExamMapper mapper, ExamValidator validator, ExamRepository repository, ExamQuestionGenerationServiceImpl examQuestionGenerationService) {
        super(mapper, validator, repository);
        this.examQuestionGenerationService = examQuestionGenerationService;
    }

    @Override
    public String create(ExamCreateDtoBegin createDto) {
        validator.validOnCreate(createDto);
        Exam exam = mapper.fromCreateDto(createDto);
        exam.setStatus((short) 300);
        return repository.save(exam).getId();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(ExamUpdateDto updateDto) {

    }

    @Override
    public ExamDto get(String id) {
        Optional<Exam> byIdAndDeletedFalse = repository.findByIdAndDeletedFalse(id);
        if (byIdAndDeletedFalse.isEmpty()) {
            throw new NotFoundExamException("Not found Exam");
        }
        ExamDto examDto = mapper.toDto(byIdAndDeletedFalse.get());
        Map<Short,Short> questionCount=new HashMap<>();
        examQuestionGenerationService.getAllByExamId(id).forEach(examQuestionGenerationDto -> {
            questionCount.put(examQuestionGenerationDto.getMark(),examQuestionGenerationDto.getCount());
        });
        examDto.setQuestionCounts(questionCount);
        return examDto;
    }

    @Override
    public List<ExamDto> getAll() {
        return mapper.toDto(repository.findAllByDeletedFalse());
    }

    public String create(ExamCreateDtoEnd dto) {
        ExamDto examDto = this.get(dto.getId());
        examDto.setDuration(dto.getDuration());
        AtomicInteger questionCount= new AtomicInteger();
        AtomicInteger mark= new AtomicInteger();
        dto.getQuestionCounts().forEach((k,v)->{
            questionCount.addAndGet(k);
            mark.addAndGet(k * v);
            examQuestionGenerationService.create(new ExamQuestionGenerationCreateDto(dto.getId(),v,k));
        });
        examDto.setQuestionCount((short) questionCount.get());
        examDto.setMaxMark((short) mark.get());
        repository.update(examDto);
        return dto.getId();
    }
}
