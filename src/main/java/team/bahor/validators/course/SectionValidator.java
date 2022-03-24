package team.bahor.validators.course;

import org.springframework.stereotype.Component;
import team.bahor.dto.course.SectionCreateDto;
import team.bahor.dto.course.SectionUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.validators.AbstractValidator;

@Component
public class SectionValidator
        extends AbstractValidator<SectionCreateDto, SectionUpdateDto, String> {

    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(SectionCreateDto courseSectionCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(SectionUpdateDto cd) throws ValidationException {

    }
}
