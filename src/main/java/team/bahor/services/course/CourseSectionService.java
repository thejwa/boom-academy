package team.bahor.services.course;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import team.bahor.dto.course.CourseSectionCreateDto;
import team.bahor.dto.course.CourseSectionDto;
import team.bahor.dto.course.CourseSectionUpdateDto;
import team.bahor.mappers.course.CourseSectionMapper;
import team.bahor.repositories.course.CourseSectionRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.services.base.GenericCrudService;
import team.bahor.validators.course.CourseSectionValidator;

import java.util.List;

@Service
public class CourseSectionService extends AbstractService<
        CourseSectionRepository,
        CourseSectionMapper,
        CourseSectionValidator>
        implements GenericCrudService<
        CourseSectionDto,
        CourseSectionCreateDto,
        CourseSectionUpdateDto,
        String> {
    protected CourseSectionService(@Qualifier("courseSectionMapper") CourseSectionMapper mapper, CourseSectionValidator validator, CourseSectionRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(CourseSectionCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(CourseSectionUpdateDto updateDto) {

    }

    @Override
    public CourseSectionDto get(String id) {
        return null;
    }

    @Override
    public List<CourseSectionDto> getAll() {
        return null;
    }
}
