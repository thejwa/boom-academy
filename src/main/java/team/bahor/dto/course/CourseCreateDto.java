package team.bahor.dto.course;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.BaseGenericDto;


@Getter
@Setter
@Builder
public class CourseCreateDto implements BaseGenericDto {

    private String name;

    private String description;

    private Double price;

    private String category;

    private Short duration;

}
