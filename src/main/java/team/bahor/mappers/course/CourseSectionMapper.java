package team.bahor.mappers.course;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import team.bahor.dto.course.CourseSectionCreateDto;
import team.bahor.dto.course.CourseSectionDto;
import team.bahor.dto.course.CourseSectionUpdateDto;
import team.bahor.entity.courses.CourseSection;
import team.bahor.mappers.base.AbstractMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public class CourseSectionMapper
        implements AbstractMapper<CourseSection, CourseSectionDto, CourseSectionCreateDto, CourseSectionUpdateDto> {
    @Override
    public CourseSectionDto toDto(CourseSection entity) {
        return null;
    }

    @Override
    public List<CourseSectionDto> toDto(List<CourseSection> entities) {
        return null;
    }

    @Override
    public CourseSection fromCreateDto(CourseSectionCreateDto createDto) {
        return null;
    }

    @Override
    public CourseSection fromUpdateDto(CourseSectionUpdateDto updateDto) {
        return null;
    }
}
