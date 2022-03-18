package team.bahor.services.course;

import org.springframework.stereotype.Service;
import team.bahor.dto.course.CourseCreateDto;
import team.bahor.dto.course.CourseDto;
import team.bahor.dto.course.CourseUpdateDto;
import team.bahor.entity.courses.Course;
import team.bahor.mappers.course.CourseMapper;
import team.bahor.repositories.course.CourseRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.services.base.GenericCrudService;
import team.bahor.validators.CourseValidator;

import java.util.List;

@Service
public class CourseService extends AbstractService<
        CourseRepository,
        CourseMapper,
        CourseValidator>
        implements GenericCrudService<
        CourseDto,
        CourseCreateDto,
        CourseUpdateDto,
        String> {

    protected CourseService(CourseMapper mapper, CourseValidator validator, CourseRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(CourseCreateDto createDto) {
        validator.validOnCreate(createDto);
        Course course = mapper.fromCreateDto(createDto);
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(CourseUpdateDto updateDto) {

    }

    @Override
    public CourseDto get(String id) {
        return null;
    }

    @Override
    public List<CourseDto> getAll() {
        return null;
    }
}
