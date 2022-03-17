package team.bahor.entity.courses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CourseSection extends Auditable {

    @Column(nullable = false, name = "course_id")
    private String courseId;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private Short position;

    @Column(nullable = false)
    private String createdBy;

    @Column(name = "is_completed", columnDefinition = "NUMERIC default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean completed;
}
