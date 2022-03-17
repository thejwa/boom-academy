package team.bahor.entity.feedback;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;
import team.bahor.enums.types.FeedbackType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Feedback extends Auditable {
    @Column(nullable = false)
    private String userId;

    @Enumerated(EnumType.STRING)
    private FeedbackType type;

    @Column(nullable = false)
    private String message;
}
