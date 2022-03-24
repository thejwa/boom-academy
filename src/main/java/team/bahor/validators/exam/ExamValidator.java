package team.bahor.validators.exam;

import team.bahor.dto.exam.ExamCreateDtoBegin;
import team.bahor.dto.exam.ExamUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.validators.AbstractValidator;

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
