package team.bahor.entity.courses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "courses")
@Entity
@NoArgsConstructor
public class Course extends Auditable {
    @Column(nullable = false)
    private String name;

    private String description;

    private Integer purchase_count;

    @Column(nullable = false)
    private Double price;

    private Integer rating;

    private Integer rating_count;

    @Column(nullable = false)
    private String created_by;

    @Column(nullable = false)
    private String category;

    @Column(name = "is_certificated", columnDefinition = "NUMERIC default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean certificated;

}
