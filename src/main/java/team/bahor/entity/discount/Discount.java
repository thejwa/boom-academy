package team.bahor.entity.discount;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Discount extends Auditable {
    @Column(nullable = false)
    private String courseId;

    private Double percentage;

    private Double amount;

    private LocalDateTime dueDate;
}
