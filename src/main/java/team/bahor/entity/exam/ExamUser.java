package team.bahor.entity.exam;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExamUser extends Auditable {
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String examId;

    private Short mark;

    private Double percentage;

    private LocalDateTime finishingTime;
}
