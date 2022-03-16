package team.bahor.entity.lesson;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "answer_lesson_questions")
@Entity
@NoArgsConstructor
public class AnswerLessonQuestion extends Auditable {
    @Column(name = "lesson_question_id", nullable = false)
    private String lessonQuestionId;

    @Column(nullable = false)
    private String title;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(columnDefinition = "integer default 0")
    private Integer likeCount;
}
