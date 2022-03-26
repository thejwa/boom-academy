package team.bahor.mappers.course;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import team.bahor.dto.course.rating.CourseRatingCreateDto;
import team.bahor.dto.course.rating.CourseRatingDto;
import team.bahor.dto.course.rating.CourseRatingUpdateDto;
import team.bahor.entity.courses.CourseRating;
import team.bahor.mappers.base.AbstractMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CourseRatingMapper extends AbstractMapper<
        CourseRating,
        CourseRatingDto,
        CourseRatingCreateDto,
        CourseRatingUpdateDto> {

    @Override
    CourseRatingDto toDto(CourseRating entity);

    @Override
    List<CourseRatingDto> toDto(List<CourseRating> entities);

    @Override
    CourseRating fromCreateDto(CourseRatingCreateDto createDto);

    @Override
    CourseRating fromUpdateDto(CourseRatingUpdateDto updateDto);
}
