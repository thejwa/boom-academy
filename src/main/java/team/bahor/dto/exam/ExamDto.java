package team.bahor.dto.exam;

import team.bahor.dto.GenericDto;

import java.util.Map;

public class ExamDto extends GenericDto {
    private String courseId;

    private Long duration; //milliseconds

    private Short questionCount;

    private Short maxMark;

    private String title;

    private String description;

    private Map<Short, Short> questionCounts;
}
