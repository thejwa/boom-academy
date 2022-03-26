package team.bahor.services.course;

import org.springframework.stereotype.Service;
import team.bahor.dto.course.CourseCreateDto;
import team.bahor.dto.course.CourseDto;
import team.bahor.dto.course.CourseUpdateDto;
import team.bahor.entity.courses.Course;
import team.bahor.enums.CourseCategory;
import team.bahor.exeptions.ValidationException;
import team.bahor.mappers.course.CourseMapper;
import team.bahor.repositories.course.CourseRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.services.base.GenericCrudService;
import team.bahor.utils.Utils;
import team.bahor.validators.course.CourseValidator;

import java.util.List;
import java.util.UUID;

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
        course.setCategory(CourseCategory.valueOf(createDto.getCategory()));
        course.setId(UUID.randomUUID().toString().replace("-",""));
        course = repository.save(course);
        return course.getId();
    }

    @Override
    public void delete(String id) {
        System.out.println("Abdumajid branch test");
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
