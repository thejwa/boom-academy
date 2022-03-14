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
@Table(name = "lessons")
@Entity
@NoArgsConstructor
public class Lesson extends Auditable {
    @Column(name = "section_id",nullable = false)
    private String sectionId;

    @Column(nullable = false)
    private short position;

    @Column(nullable = false)
    private String content;

    @Column(name = "video_url",nullable = false)
    private String videoUrl;

    @Column(name = "created_by",nullable = false)
    private String createdBy;
}
