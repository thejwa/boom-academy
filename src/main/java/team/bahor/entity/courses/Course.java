package team.bahor.entity.courses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import team.bahor.entity.base.Auditable;
import team.bahor.enums.CourseCategory;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "courses", indexes = {
        @Index(name = "indexjdlfsdfjdklsfjvksadfbkds", columnList = "name"),
        @Index(name = "laskdfhelkjsd", columnList = "createdBy"),
        @Index(name = "lasdkjadsflal", columnList = "category")
})
@Entity
@NoArgsConstructor
public class Course extends Auditable {
    @Column(nullable = false)
    private String name;

    private String description;

    private Integer purchaseCount;

    @Column(nullable = false)
    private Double price;

    private Integer rating;

    private Integer ratingCount;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseCategory category;

    @Column(name = "is_certificated", columnDefinition = "NUMERIC default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean certificated;


}
