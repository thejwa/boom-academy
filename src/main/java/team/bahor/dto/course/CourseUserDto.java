package team.bahor.dto.course;

import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.BaseGenericDto;

@Getter
@Setter
public class CourseUserDto implements BaseGenericDto {
    private String fullName;

    private String username;

    private String photo_url;

    private String email;

    private String phone;
}
