package team.bahor.services.exam.examQuestion;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import team.bahor.dto.exam.examQuestion.ExamQuestionCreateDto;
import team.bahor.dto.exam.examQuestion.ExamQuestionDto;
import team.bahor.dto.exam.examQuestion.ExamQuestionUpdateDto;
import team.bahor.entity.exam.ExamQuestion;
import team.bahor.enums.types.QuestionType;
import team.bahor.mappers.exam.ExamQuestionMapper;
import team.bahor.repositories.exam.ExamQuestionRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.services.exam.answerToExamQuestion.AnswerToExamQuestionService;
import team.bahor.services.exam.answerToExamQuestion.AnswerToExamQuestionServiceImpl;
import team.bahor.validators.exam.ExamQuestionValidator;

import java.util.List;

@Service
public class ExamQuestionServiceImpl extends AbstractService<
        ExamQuestionRepository,
        ExamQuestionMapper,
        ExamQuestionValidator
        > implements ExamQuestionService {
    public ExamQuestionServiceImpl(@Qualifier("examQuestionMapperImpl") ExamQuestionMapper mapper, ExamQuestionValidator validator, ExamQuestionRepository repository, AnswerToExamQuestionServiceImpl answerToExamQuestionService) {
        super(mapper, validator, repository);
        this.answerToExamQuestionService = answerToExamQuestionService;
    }

    private final AnswerToExamQuestionServiceImpl answerToExamQuestionService;

    @Override
    public String create(ExamQuestionCreateDto createDto) {
        validator.validOnCreate(createDto);
        ExamQuestion examQuestion = mapper.fromCreateDto(createDto);
        examQuestion.setType(QuestionType.get(createDto.getType()));
        createDto.getAnswers().forEach(answerToExamQuestionCreateDto -> {
            answerToExamQuestionService.create(answerToExamQuestionCreateDto);
        });
        return repository.save(examQuestion).getId();
    }

    @Override
    public void delete(String id) {
        repository.deleted(id);
    }

    @Override
    public void update(ExamQuestionUpdateDto updateDto) {

    }

    @Override
    public ExamQuestionDto get(String id) {
        return mapper.toDto(repository.getByIdAndDeletedIsFalse(id));
    }

    @Override
    public List<ExamQuestionDto> getAll() {
        return mapper.toDto(repository.getByDeletedFalse());
    }
}
