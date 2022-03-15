package team.bahor.mappers;

import team.bahor.dto.course.CourseCreateDto;
import team.bahor.dto.course.CourseDto;
import team.bahor.dto.course.CourseUpdateDto;
import team.bahor.entity.courses.Course;
import team.bahor.mappers.base.AbstractMapper;

public interface CourseMapper extends AbstractMapper<
        Course,
        CourseDto,
        CourseCreateDto,
        CourseUpdateDto> {

}
