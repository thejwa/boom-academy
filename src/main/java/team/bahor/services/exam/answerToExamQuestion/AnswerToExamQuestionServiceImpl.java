package team.bahor.services.exam.answerToExamQuestion;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import team.bahor.dto.exam.answerToExamQuestion.AnswerToExamQuestionCreateDto;
import team.bahor.dto.exam.answerToExamQuestion.AnswerToExamQuestionDto;
import team.bahor.dto.exam.answerToExamQuestion.AnswerToExamQuestionUpdateDto;
import team.bahor.mappers.exam.AnswerToExamQuestionMapper;
import team.bahor.repositories.exam.AnswerToExamQuestionRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.validators.exam.AnswerToExamQuestionValidator;

import java.util.List;
@Service
public class AnswerToExamQuestionServiceImpl extends AbstractService<
        AnswerToExamQuestionRepository,
        AnswerToExamQuestionMapper,
        AnswerToExamQuestionValidator
        > implements AnswerToExamQuestionService{
    public AnswerToExamQuestionServiceImpl(@Qualifier("answerToExamQuestionMapperImpl") AnswerToExamQuestionMapper mapper, AnswerToExamQuestionValidator validator, AnswerToExamQuestionRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(AnswerToExamQuestionCreateDto createDto) {
        return repository.save(mapper.fromCreateDto(createDto)).getId();
    }

    @Override
    public void delete(String id) {
        repository.deleted(id);
    }

    @Override
    public void update(AnswerToExamQuestionUpdateDto updateDto) {

    }

    @Override
    public AnswerToExamQuestionDto get(String id) {
        validator.validateKey(id);//todo validator
        return mapper.toDto(repository.getByIdAndDeletedIsFalse(id));
    }

    @Override
    public List<AnswerToExamQuestionDto> getAll() {
        //todo validator
        return mapper.toDto(repository.getByDeletedFalse());
    }
}
