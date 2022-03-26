package team.bahor.validators.course;

import org.springframework.stereotype.Component;
import team.bahor.dto.course.CourseCreateDto;
import team.bahor.dto.course.CourseUpdateDto;
import team.bahor.enums.CourseCategory;
import team.bahor.exeptions.ValidationException;
import team.bahor.exeptions.course.CategoryNotAvailableException;
import team.bahor.exeptions.course.CourseForbiddenException;
import team.bahor.validators.AbstractValidator;

@Component
public class CourseValidator extends AbstractValidator<
        CourseCreateDto,
        CourseUpdateDto,
        String> {

    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(CourseCreateDto courseCreateDto) {

        if (!CourseCategory.getAll().contains(CourseCategory.valueOf(courseCreateDto.getCategory())))
            throw new CategoryNotAvailableException("Not available");
        if (courseCreateDto.getPrice() < 0 || courseCreateDto.getDuration() < 0)
            throw new CourseForbiddenException("Not possible to enter a negative number");

    }

    @Override
    public void validOnUpdate(CourseUpdateDto cd) throws ValidationException {

    }
}
