package team.bahor.entity.finance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Coupon extends Auditable {

    @Column(nullable = false)
    private String courseId;

    @Column(nullable = false)
    private String code;

    private LocalDate dueDate;

    private Integer limitSize;

    private Double discountAmount;

    private Double discountPercentage;

}

