package team.bahor.dto.exam.examQuestion;

import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;
import team.bahor.dto.exam.answerToExamQuestion.AnswerToExamQuestionCreateDto;
import team.bahor.enums.types.QuestionType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ExamQuestionDto extends GenericDto {
    private String examId;

    private String title;

    private QuestionType type;

    private Short mark;

    private List<AnswerToExamQuestionCreateDto> answers=new ArrayList<>();
}
