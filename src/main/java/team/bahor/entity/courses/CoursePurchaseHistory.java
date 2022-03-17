package team.bahor.entity.courses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(indexes = {
        @Index(name = "course_project_history_status_index", columnList = "status")
})
public class CoursePurchaseHistory extends Auditable {
    @Column(nullable = false)
    private String courseId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Double payment_amount;

    private String couponId;

    private Double discount; // -> discount will be given in percentages, if this field is null or equals to zero then there is no discount
}
