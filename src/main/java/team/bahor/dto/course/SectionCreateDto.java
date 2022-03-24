package team.bahor.dto.course;

import team.bahor.dto.BaseGenericDto;

import javax.validation.constraints.NotNull;

public class SectionCreateDto implements BaseGenericDto {
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
}
