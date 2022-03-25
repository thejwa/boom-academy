package team.bahor.validators.section;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.bahor.dto.section.SectionCreateDto;
import team.bahor.dto.section.SectionUpdateDto;
import team.bahor.entity.courses.Section;
import team.bahor.exeptions.ValidationException;
import team.bahor.exeptions.course.SectionForbiddenException;
import team.bahor.exeptions.course.SectionNotFoundException;
import team.bahor.repositories.course.CourseRepository;
import team.bahor.repositories.course.SectionRepository;
import team.bahor.utils.Utils;
import team.bahor.validators.AbstractValidator;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SectionValidator
        extends AbstractValidator<SectionCreateDto, SectionUpdateDto, String> {
    private final SectionRepository sectionRepository;
    private final CourseRepository courseRepository;


    @Override
    public void validateKey(String id) throws ValidationException {
        Optional<Section> sectionOptional = sectionRepository.findByNoDeletedSection(id, Utils.getSessionId());
        if (sectionOptional.isEmpty())
            throw new SectionNotFoundException("Section not found");

    }

    @Override
    public void validOnCreate(SectionCreateDto dto) {
        if (!courseRepository.existsByIdAndCreatedBy(dto.getCourseId(), dto.getCreatedBy()))
            throw new SectionForbiddenException("Not allowed");
    }

    @Override
    public void validOnUpdate(SectionUpdateDto dto) throws ValidationException {
        Optional<Section> sectionOptional = sectionRepository.findByNoDeletedSection(dto.getId(), Utils.getSessionId());
        if (sectionOptional.isEmpty())
            throw new SectionNotFoundException("Section not found");

    }

    public void validOptionalSection(Optional<Section> optionalSection) {
        if (optionalSection.isEmpty())
            throw new SectionNotFoundException("Section not found");
    }

}
