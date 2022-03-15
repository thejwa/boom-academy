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
@Table(name = "lesson_questions")
@Entity
@NoArgsConstructor
public class LessonQuestion extends Auditable {
    @Column(nullable = false)
    private String lessonId;

    @Column(nullable =false)
    private String title;

    @Column(nullable = false)
    private String createdBy;

    @Column(columnDefinition = "integer default 0")
    private int likeCount;
}
