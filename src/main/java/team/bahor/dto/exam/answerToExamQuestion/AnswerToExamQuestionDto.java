package team.bahor.dto.exam.answerToExamQuestion;

import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;

@Setter
@Getter
public class AnswerToExamQuestionDto extends GenericDto {
    private String examQuestionId;

    private String title;

    private boolean correct;
}
