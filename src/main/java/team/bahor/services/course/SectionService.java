package team.bahor.services.course;

import team.bahor.dto.course.SectionCreateDto;
import team.bahor.dto.course.SectionDto;
import team.bahor.dto.course.SectionUpdateDto;
import team.bahor.services.base.GenericCrudService;

public interface SectionService extends GenericCrudService<
        SectionDto,
        SectionCreateDto,
        SectionUpdateDto,
        String> {

}
