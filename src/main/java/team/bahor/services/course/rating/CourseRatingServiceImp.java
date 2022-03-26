package team.bahor.services.course.rating;

import org.springframework.stereotype.Service;
import team.bahor.dto.course.rating.CourseRatingCreateDto;
import team.bahor.dto.course.rating.CourseRatingDto;
import team.bahor.dto.course.rating.CourseRatingUpdateDto;
import team.bahor.mappers.course.CourseRatingMapper;
import team.bahor.repositories.course.CourseRatingRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.validators.course.rating.CourseRatingValidator;

import java.util.List;

@Service
public class CourseRatingServiceImp extends AbstractService<
        CourseRatingRepository,
        CourseRatingMapper,
        CourseRatingValidator> implements CourseRatingService {

    protected CourseRatingServiceImp(CourseRatingMapper mapper, CourseRatingValidator validator, CourseRatingRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(CourseRatingCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(CourseRatingUpdateDto updateDto) {

    }

    @Override
    public CourseRatingDto get(String id) {
        return null;
    }

    @Override
    public List<CourseRatingDto> getAll() {
        return null;
    }
}
