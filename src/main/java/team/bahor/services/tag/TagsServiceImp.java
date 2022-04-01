package team.bahor.services.tag;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import team.bahor.dto.tag.TagCreateDto;
import team.bahor.dto.tag.TagDto;
import team.bahor.dto.tag.TagUpdateDto;
import team.bahor.mappers.tag.TagsMapper;
import team.bahor.repositories.tag.TagsRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.validators.tag.TagsValidator;

import java.util.List;

@Service
public class TagsServiceImp extends AbstractService<
        TagsRepository,
        TagsMapper,
        TagsValidator> implements TagsService {

    protected TagsServiceImp(@Qualifier("tagsMapperImpl") TagsMapper mapper, TagsValidator validator, TagsRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(TagCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(TagUpdateDto updateDto) {

    }

    @Override
    public TagDto get(String id) {
        return null;
    }

    @Override
    public List<TagDto> getAll() {
        return null;
    }

    public List<TagDto> getAllTag(String tagId) {
        return null;
    }

}
