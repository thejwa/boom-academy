package team.bahor.validators;

import org.springframework.stereotype.Component;
import team.bahor.dto.course.CourseCreateDto;
import team.bahor.dto.course.CourseUpdateDto;
import team.bahor.exeptions.ValidationException;

@Component
public class CourseValidator extends AbstractValidator<
        CourseCreateDto,
        CourseUpdateDto,
        String> {

    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(CourseCreateDto courseCreateDto) throws ValidationException {


    }

    @Override
    public void validOnUpdate(CourseUpdateDto cd) throws ValidationException {

    }
}
