package team.bahor.dto.exam.exam;

import team.bahor.dto.BaseGenericDto;
import team.bahor.dto.GenericDto;

import java.util.Map;

public class ExamCreateDtoBegin implements BaseGenericDto {
    private String courseId;

    private String title;

    private String description;

    public static class ExamCreateDtoEnd extends GenericDto {
        private Long duration; //milliseconds

        private Map<Short, Short> questionCounts;//1-element questionning mark 2-element questionning count
    }
}
