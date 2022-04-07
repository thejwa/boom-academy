package team.bahor.validators.course.purchase;

import org.springframework.stereotype.Component;
import team.bahor.dto.course.purchase.CoursePurchaseCreateDto;
import team.bahor.dto.course.purchase.CoursePurchaseUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.validators.base.AbstractValidator;

@Component
public class CoursePurchaseValidator extends AbstractValidator<
        CoursePurchaseCreateDto,
        CoursePurchaseUpdateDto,
        String> {

    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(CoursePurchaseCreateDto coursePurchaseCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(CoursePurchaseUpdateDto cd) throws ValidationException {

    }
}
