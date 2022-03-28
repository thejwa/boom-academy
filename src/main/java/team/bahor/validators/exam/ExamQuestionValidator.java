package team.bahor.validators.exam;

import org.springframework.stereotype.Component;
import team.bahor.dto.exam.answerToExamQuestion.AnswerToExamQuestionCreateDto;
import team.bahor.dto.exam.examQuestion.ExamQuestionCreateDto;
import team.bahor.dto.exam.examQuestion.ExamQuestionUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.exeptions.exam.NotValidOnCreateException;
import team.bahor.validators.base.AbstractValidator;
@Component
public class ExamQuestionValidator extends AbstractValidator<
        ExamQuestionCreateDto,
        ExamQuestionUpdateDto,
        String
        > {
    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ExamQuestionCreateDto examQuestionCreateDto) throws ValidationException {
        //todo userId ni tekshir
        int correctCount= (int) examQuestionCreateDto.getAnswers().stream().filter(AnswerToExamQuestionCreateDto::isCorrect).count();
        if ( correctCount != 1 ){
            throw new NotValidOnCreateException("Not Valid On Create");
        }
    }


    @Override
    public void validOnUpdate(ExamQuestionUpdateDto cd) throws ValidationException {

    }
}
