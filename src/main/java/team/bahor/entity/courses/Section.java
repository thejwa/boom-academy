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
@Table(name = "section_of_courses")
@Entity
@NoArgsConstructor
public class Section extends Auditable {

    @Column(nullable = false,name = "course_id")
    private String courseId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Short position;

    @Column(nullable = false)
    private String createdBy;
}
