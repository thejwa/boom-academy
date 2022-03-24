package team.bahor.dto.exam;

import team.bahor.dto.GenericDto;

import java.util.Map;

public class ExamCreateDtoEnd extends GenericDto {
    private String courseId;

    private Long duration; //milliseconds

    private Map<Short, Short> questionCounts;
}
