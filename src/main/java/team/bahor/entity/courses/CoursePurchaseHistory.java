package team.bahor.entity.courses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CoursePurchaseHistory extends Auditable {
    @Column(nullable = false)
    private String courseId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Double payment_amount;

    private String coupon;

    private Double discount; // -> discount will be given in percentages, if this field is null or equals to zero then there is no discount
}
