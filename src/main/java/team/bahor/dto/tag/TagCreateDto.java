package team.bahor.dto.tag;

import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.BaseGenericDto;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TagCreateDto implements BaseGenericDto {
    @NotBlank
    private String name;

    @NotBlank
    private String courseId;
}
