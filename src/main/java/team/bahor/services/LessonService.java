package team.bahor.services;

import team.bahor.dto.lesson.LessonCreateDto;
import team.bahor.dto.lesson.LessonDto;
import team.bahor.dto.lesson.LessonUpdateDto;
import team.bahor.mappers.LessonMapper;
import team.bahor.repositories.LessonRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.services.base.GenericCrudService;
import team.bahor.validators.LessonValidator;

import java.util.List;

public class LessonService extends AbstractService<
        LessonRepository,
        LessonMapper,
        LessonValidator>
        implements GenericCrudService<
        LessonDto,
        LessonCreateDto,
        LessonUpdateDto,
        String> {
    protected LessonService(LessonMapper mapper, LessonValidator validator, LessonRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(LessonCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(LessonUpdateDto updateDto) {

    }

    @Override
    public LessonDto get(String id) {
        return null;
    }

    @Override
    public List<LessonDto> getAll(String id) {
        return null;
    }
}
