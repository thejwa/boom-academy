package team.bahor.validators.tag;

import org.springframework.stereotype.Component;
import team.bahor.dto.tag.TagCreateDto;
import team.bahor.dto.tag.TagUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.validators.base.AbstractValidator;

@Component
public class TagsValidator extends AbstractValidator<
        TagCreateDto,
        TagUpdateDto,
        String> {


    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(TagCreateDto tagCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(TagUpdateDto cd) throws ValidationException {

    }
}
