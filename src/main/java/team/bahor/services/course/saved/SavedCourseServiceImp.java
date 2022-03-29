package team.bahor.services.course.saved;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import team.bahor.dto.course.saved.SavedCourseCreateDto;
import team.bahor.dto.course.saved.SavedCourseDto;
import team.bahor.dto.course.saved.SavedCourseUpdateDto;
import team.bahor.entity.courses.SavedCourse;
import team.bahor.mappers.course.SavedCourseMapper;
import team.bahor.repositories.course.SavedCourseRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.validators.course.saved.SavedCourseValidator;

import java.util.List;

@Service
public class SavedCourseServiceImp extends AbstractService<
        SavedCourseRepository,
        SavedCourseMapper,
        SavedCourseValidator> implements SavedCourseService {

    protected SavedCourseServiceImp(SavedCourseMapper mapper, SavedCourseValidator validator, SavedCourseRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(SavedCourseCreateDto createDto) {
        if (validator.validOnCreated(createDto)){
            delete(createDto.getUserId(), createDto.getCourseId());
            return "Deleted";
        }
        SavedCourse savedCourse = mapper.fromCreateDto(createDto);
        repository.save(savedCourse);
        return "Saved";
    }

    @Override
    public SavedCourseDto get(String id) {
        return null;
    }

    @Override
    public List<SavedCourseDto> getAll() {
        return null;
    }

    public List<SavedCourseDto> getAllUserSavedCourse(String userId) {
        return null;
    }

    @Override
    public void update(SavedCourseUpdateDto updateDto) {
    }

    @Override
    public void delete(String id) {

    }

    @Async
    public void delete(String userId, String courseId) {
        validator.validOnCreatedUser(userId);
        repository.deleteThisUserSavedCourse(userId, courseId);
    }


}
