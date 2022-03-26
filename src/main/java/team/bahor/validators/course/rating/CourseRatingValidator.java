package team.bahor.validators.course.rating;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.bahor.dto.course.rating.CourseRatingCreateDto;
import team.bahor.dto.course.rating.CourseRatingUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.exeptions.course.rating.CourseRatingInvalidException;
import team.bahor.exeptions.course.rating.CourseRatingUserMarkException;
import team.bahor.repositories.course.CourseUserRepository;
import team.bahor.validators.AbstractValidator;

@Component
@RequiredArgsConstructor
public class CourseRatingValidator extends AbstractValidator<CourseRatingCreateDto, CourseRatingUpdateDto, String> {

    private final CourseUserRepository courseUserRepository;

    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(CourseRatingCreateDto courseRatingCreateDto) throws ValidationException {
        if (courseRatingCreateDto.getRating() >= 0 && 5 >= courseRatingCreateDto.getRating())
            throw new CourseRatingInvalidException("Rating Data Invalid !");

        if (!courseUserRepository.existsByCourseIdAndUserIdAndStatus(courseRatingCreateDto.getCourseId(), courseRatingCreateDto.getUserId(), (short) 0))
            throw new CourseRatingUserMarkException("This User Is Not Allowed To Rate The Course");
    }

    @Override
    public void validOnUpdate(CourseRatingUpdateDto cd) throws ValidationException {

    }
}
