package team.bahor.entity.coupon;

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
    private String course_id;

    @Column(nullable = false)
    private String code;

    private LocalDate due_date;

    private Integer limit_size;

    private Integer discount_amount;

    private Integer discount_percentage;

}

