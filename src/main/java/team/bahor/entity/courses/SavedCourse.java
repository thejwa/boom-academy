package team.bahor.entity.courses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "saved_courses")
@Entity
@NoArgsConstructor
public class SavedCourse extends Auditable {

    @Column(nullable = false)
    private String course_id;

    @Column(nullable = false)
    private String user_id;

}
