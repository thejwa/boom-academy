package team.bahor.dto.exam.exam;

import team.bahor.dto.GenericDto;

import java.util.Map;

public class ExamUpdateDto extends GenericDto {
    private Long duration; //milliseconds

    private String title;

    private String description;

    private Map<String, Integer> questionCounts;
}

