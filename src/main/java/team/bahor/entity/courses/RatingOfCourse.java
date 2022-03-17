package team.bahor.entity.courses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class RatingOfCourse extends Auditable {
    @Column(nullable = false)
    private String courseId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String rating;
}
