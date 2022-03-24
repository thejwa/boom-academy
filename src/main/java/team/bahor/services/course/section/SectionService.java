package team.bahor.services.course.section;

import team.bahor.dto.section.SectionCreateDto;
import team.bahor.dto.section.SectionDto;
import team.bahor.dto.section.SectionUpdateDto;
import team.bahor.services.base.GenericCrudService;

public interface SectionService extends GenericCrudService<
        SectionDto,
        SectionCreateDto,
        SectionUpdateDto,
        String> {

}
