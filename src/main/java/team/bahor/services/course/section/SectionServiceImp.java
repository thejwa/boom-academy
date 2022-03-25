package team.bahor.services.course.section;

import org.springframework.stereotype.Service;
import team.bahor.dto.section.SectionCreateDto;
import team.bahor.dto.section.SectionDto;
import team.bahor.dto.section.SectionPositionUpdateDto;
import team.bahor.dto.section.SectionUpdateDto;
import team.bahor.entity.courses.Section;
import team.bahor.mappers.course.SectionMapper;
import team.bahor.repositories.course.SectionRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.utils.Utils;
import team.bahor.validators.section.SectionValidator;

import java.util.List;
import java.util.Optional;

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

        validator.validOnCreate(createDto);
        Section section = mapper.fromCreateDto(createDto);

        short length = repository.countSectionByCourseId(section.getCourseId());
        if (length > section.getPosition())
            repository.updatePositionSection(section.getCourseId(), section.getPosition(), Utils.getSessionId());
        else
            section.setPosition((short) (length + 1));

        repository.save(section);
        return "Saved section !";
    }

    @Override
    public SectionDto get(String id) {
        Optional<Section> optionalSection = repository.findByNoDeletedSection(id, Utils.getSessionId());
        validator.validOptionalSection(optionalSection);
        return mapper.toDto(optionalSection.get());
    }


    @Override
    public List<SectionDto> getAll() {
//        List<Section> sectionList = repository.findAllSections();
//        return mapper.toDto(sectionList);
        return null;
    }

    public List<SectionDto> getCourseSections(String id){
        List<Section> allCourseSections = repository.findAllByCourseIdAAndDelete(id, Utils.getSessionId());
        validator.validOnCreate(id);
        return  mapper.toDto(allCourseSections);
    }


    @Override
    public void update(SectionUpdateDto updateDto) {
        Optional<Section> optionalSection = repository.findByNoDeletedSection(updateDto.getId(), Utils.getSessionId());
        validator.validOptionalSection(optionalSection);
        Section section = mapper.fromUpdateDto(updateDto, optionalSection.get());
        repository.save(section);
    }

    @Override
    public void delete(String id) {
        validator.validateKey(id);
        repository.deleteBySection(id, Utils.getSessionId());
    }

    public void updatePosition(SectionPositionUpdateDto dto) {
        Optional<Section> optionalSection = repository.findByNoDeletedSection(dto.getId(), Utils.getSessionId());
        validator.validOptionalSection(optionalSection);

        Section section = mapper.fromUpdateDto(dto, optionalSection.get());

        short def = optionalSection.get().getPosition();
        short leng = repository.countSectionByCourseId(section.getCourseId());
        short position = section.getPosition();

        if (leng > position && position > def)
            repository.updatePositionRightSection(section.getCourseId(), position, def, Utils.getSessionId());
        else if (leng > position && position < def)
            repository.updatePositionLeftSection(section.getCourseId(), position, def, Utils.getSessionId());
        else
            section.setPosition((short) (leng + 1));

        repository.save(section);

    }

}
