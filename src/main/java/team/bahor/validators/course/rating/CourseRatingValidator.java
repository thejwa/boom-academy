package team.bahor.validators.course.rating;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.bahor.dto.course.rating.CourseRatingCreateDto;
import team.bahor.dto.course.rating.CourseRatingUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.validators.AbstractValidator;

@Component
@RequiredArgsConstructor
public class CourseRatingValidator extends AbstractValidator<CourseRatingCreateDto, CourseRatingUpdateDto, String> {

    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(CourseRatingCreateDto courseRatingCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(CourseRatingUpdateDto cd) throws ValidationException {

    }
}
