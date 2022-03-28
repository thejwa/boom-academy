package team.bahor.dto.course;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import team.bahor.dto.BaseGenericDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@Builder
public class CourseCreateDto implements BaseGenericDto {

    @Pattern(regexp = "\\w")
    private String name;

    private String description;

    @NotBlank
    private Double price;

    @NotBlank
    private String category;

    private Short duration;

}
