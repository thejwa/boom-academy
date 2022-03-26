package team.bahor.validators.exam;

import org.springframework.stereotype.Component;
import team.bahor.dto.exam.answerToExamQuestion.AnswerToExamQuestionCreateDto;
import team.bahor.dto.exam.answerToExamQuestion.AnswerToExamQuestionUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.validators.base.AbstractValidator;
@Component
public class AnswerToExamQuestionValidator extends AbstractValidator<
        AnswerToExamQuestionCreateDto,
        AnswerToExamQuestionUpdateDto,
        String
        > {
    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(AnswerToExamQuestionCreateDto answerToExamQuestionCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(AnswerToExamQuestionUpdateDto cd) throws ValidationException {

    }
}
