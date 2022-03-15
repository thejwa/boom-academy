package team.bahor.entity.lesson;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "notes_to_lessons")
@Entity
@NoArgsConstructor
public class NotesToLessons extends Auditable {
    @Column(name = "created_by",nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String lessonId;
}
