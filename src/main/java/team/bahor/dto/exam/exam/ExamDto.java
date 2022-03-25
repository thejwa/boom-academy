package team.bahor.dto.exam.exam;

import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;

import java.util.Map;
@Getter
@Setter
public class ExamDto extends GenericDto {
    private String courseId;

    private Long duration; //milliseconds

    private Short questionCount;

    private Short maxMark;

    private String title;

    private String description;

    private Map<Short, Short> questionCounts;
}
