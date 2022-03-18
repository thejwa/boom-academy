package team.bahor.validators.course;

import org.springframework.stereotype.Component;
import team.bahor.dto.course.CourseSectionCreateDto;
import team.bahor.dto.course.CourseSectionUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.validators.AbstractValidator;

@Component
public class CourseSectionValidator
        extends AbstractValidator<
        CourseSectionCreateDto,
        CourseSectionUpdateDto,
        String> {
    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(CourseSectionCreateDto courseSectionCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(CourseSectionUpdateDto cd) throws ValidationException {

    }
}
