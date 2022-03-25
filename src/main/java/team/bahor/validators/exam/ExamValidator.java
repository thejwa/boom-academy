package team.bahor.validators.exam;

import org.springframework.stereotype.Component;
import team.bahor.dto.exam.exam.ExamCreateDtoBegin;
import team.bahor.dto.exam.exam.ExamUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.validators.AbstractValidator;
@Component
public class ExamValidator extends AbstractValidator<ExamCreateDtoBegin, ExamUpdateDto, String> {
    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ExamCreateDtoBegin examCreateDtoBegin) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ExamUpdateDto cd) throws ValidationException {

    }
}
