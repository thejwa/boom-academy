package team.bahor.entity.courses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;
import team.bahor.enums.types.CommentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CourseComment extends Auditable {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private String somethingId; //this might be courseId or commentId

    @Enumerated(EnumType.STRING)
    private CommentType type;
}
