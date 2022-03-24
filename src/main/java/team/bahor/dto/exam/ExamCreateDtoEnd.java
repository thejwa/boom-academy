package team.bahor.dto.exam;

import team.bahor.dto.GenericDto;

import java.util.Map;

public class ExamCreateDtoEnd extends GenericDto {
    private Long duration; //milliseconds

    private Map<Short, Short> questionCounts;//1-element questionning mark 2-element questionning count
}
