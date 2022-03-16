package team.bahor.entity.quiz;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class QuizQuestionUser {
    @Id
    @Column(unique = true)
    private String id;

    @Column(nullable = false)
    private String quizId;

    @Column(columnDefinition = "NUMERIC default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean correctlySolved;

    @Column(nullable = false)
    private String quizQuestionId;
}
