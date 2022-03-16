package team.bahor.entity.quiz;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Bu entity userlar ishlagan quizlarni saqlab ketadi
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
public class QuizUser extends Auditable {
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String quizId;

    @Column(nullable = false)
    private Short mark;

    @Column(nullable = false)
    private Double percentage;

    private LocalDateTime finishing_time;

}
