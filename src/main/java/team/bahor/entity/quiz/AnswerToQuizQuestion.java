package team.bahor.entity.quiz;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AnswerToQuizQuestion {
    @Id
    @Column(unique = true)
    private String id;

    @Column(nullable = false)
    private String quizQuestionId;

    @Column(nullable = false)
    private String title;

    private boolean correct;
}
