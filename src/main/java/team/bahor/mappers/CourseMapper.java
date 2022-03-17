package team.bahor.mappers;

import org.mapstruct.Mapper;
import team.bahor.dto.course.CourseCreateDto;
import team.bahor.dto.course.CourseDto;
import team.bahor.dto.course.CourseUpdateDto;
import team.bahor.entity.courses.Course;
import team.bahor.mappers.base.AbstractMapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper extends AbstractMapper<
        Course,
        CourseDto,
        CourseCreateDto,
        CourseUpdateDto> {

    @Override
    CourseDto toDto(Course entity);

    @Override
    List<CourseDto> toDto(List<Course> entities);

    @Override
    Course fromCreateDto(CourseCreateDto createDto);

    @Override
    Course fromUpdateDto(CourseUpdateDto updateDto);
}
