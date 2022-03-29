package team.bahor.services.course.rating;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import team.bahor.dto.course.rating.CourseRatingCreateDto;
import team.bahor.dto.course.rating.CourseRatingDto;
import team.bahor.dto.course.rating.CourseRatingUpdateDto;
import team.bahor.entity.courses.Course;
import team.bahor.entity.courses.CourseRating;
import team.bahor.exeptions.course.rating.CourseRatingNotFoundException;
import team.bahor.mappers.course.CourseRatingMapper;
import team.bahor.repositories.course.CourseRatingRepository;
import team.bahor.repositories.course.CourseRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.utils.Utils;
import team.bahor.validators.course.rating.CourseRatingValidator;

import java.util.List;
import java.util.Optional;

@Service
public class CourseRatingServiceImp extends AbstractService<
        CourseRatingRepository,
        CourseRatingMapper,
        CourseRatingValidator> implements CourseRatingService {

    private final CourseRepository courseRepository;

    protected CourseRatingServiceImp(@Qualifier("courseRatingMapperImpl") CourseRatingMapper mapper, CourseRatingValidator validator, CourseRatingRepository repository, CourseRepository courseRepository) {
        super(mapper, validator, repository);
        this.courseRepository = courseRepository;
    }


    @Override
    public String create(CourseRatingCreateDto createDto) {
        validator.validOnCreate(createDto);
        Optional<CourseRating> byCourseIdAndUserId = repository.findByCourseIdAndUserId(createDto.getCourseId(), createDto.getUserId());

        float addRating = 0;
        CourseRating courseRating = null;
        if (byCourseIdAndUserId.isEmpty()) {
            courseRating = mapper.fromCreateDto(createDto);
            addRating = createDto.getRating();
            update(createDto.getCourseId(), addRating, false);
        } else {
            courseRating = mapper.fromUpdateDto(createDto, byCourseIdAndUserId.get());
            addRating = byCourseIdAndUserId.get().getRating() - createDto.getRating();
            update(createDto.getCourseId(), addRating, true);
        }
        repository.save(courseRating);

        return "Saved";
    }

    @Override
    public void update(CourseRatingUpdateDto updateDto) {
        validator.validOnUpdate(updateDto);
        Optional<CourseRating> byCourseIdAndUserId = repository.findByCourseIdAndUserId(updateDto.getCourseId(), updateDto.getUserId());

        CourseRating courseRating = mapper.fromUpdateDto(updateDto, byCourseIdAndUserId.get());
        float addRating = byCourseIdAndUserId.get().getRating() - updateDto.getRating();

        update(updateDto.getCourseId(), addRating, true);
        repository.save(courseRating);
    }

    @Async
    public void update(String courseId, float rating, boolean created) {
        Course course = validator.validateKeyCourse(courseId);
        boolean a = "a".equals("b");
        int ratingCount = course.getRatingCount();
        float rating1 = course.getRating() * ratingCount;

        if (created)
            ratingCount = ratingCount + 1;

        course.setRating((rating1 + rating) / ratingCount);
        course.setRatingCount(ratingCount);

        courseRepository.save(course);

    }

    @Override
    public CourseRatingDto get(String id) {
        validator.validateKey(id);
        Optional<CourseRating> optionalCourseRating = repository.courseById(id);
        if (optionalCourseRating.isPresent())
            return mapper.toDto(optionalCourseRating.get());
        throw new CourseRatingNotFoundException("Not Found !");
    }

    @Override
    public List<CourseRatingDto> getAll() {
        return null;
    }

    public List<CourseRatingDto> getAll(String cId) {
        validator.findByIdAuthorizated();
        List<CourseRating> allByCourseId = repository.findAllByCourseId(cId);
        return mapper.toDto(allByCourseId);
    }

    @Override
    public void delete(String id) {
        validator.validateKey(id);
        repository.courseDeleteByCourseRating(id, Utils.getSessionId());
    }
}
