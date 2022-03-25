package team.bahor.dto.exam.exam;

import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;

import java.util.Map;
@Getter
@Setter
public class ExamCreateDtoEnd extends GenericDto {
    private Long duration; //milliseconds

    private Map<Short, Short> questionCounts;//1-element questionning mark 2-element questionning count
}
