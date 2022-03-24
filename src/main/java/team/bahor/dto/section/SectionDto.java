package team.bahor.dto.section;

import team.bahor.dto.GenericDto;

import javax.validation.constraints.NotNull;

public class SectionDto extends GenericDto {

    @NotNull
    private String courseId;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Short position;

    @NotNull
    private String createdBy;

    @NotNull
    private Short status;

}
