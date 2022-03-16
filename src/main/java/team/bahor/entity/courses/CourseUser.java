package team.bahor.entity.courses;

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
public class CourseUser extends Auditable {
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String courseId;

    @Column(columnDefinition = "boolean default false")
    private boolean started;

    private LocalDateTime startedAt;
}
