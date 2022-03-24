package team.bahor.services.course;

import org.springframework.stereotype.Service;
import team.bahor.dto.course.SectionCreateDto;
import team.bahor.dto.course.SectionDto;
import team.bahor.dto.course.SectionUpdateDto;
import team.bahor.mappers.course.SectionMapper;
import team.bahor.repositories.course.SectionRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.validators.course.SectionValidator;

import java.util.List;

@Service
public class SectionServiceImp extends AbstractService<
        SectionRepository,
        SectionMapper,
        SectionValidator> implements SectionService {

    protected SectionServiceImp(SectionMapper mapper, SectionValidator validator, SectionRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(SectionCreateDto createDto) {
        return null;
    }

    @Override
    public SectionDto get(String id) {
        return null;
    }

    @Override
    public List<SectionDto> getAll() {
        return null;
    }

    @Override
    public void update(SectionUpdateDto updateDto) {

    }

    @Override
    public void delete(String id) {

    }
}
