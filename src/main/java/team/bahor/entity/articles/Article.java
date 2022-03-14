package team.bahor.entity.articles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "articles")
@Entity
@NoArgsConstructor
public class Article extends Auditable {
    @Column(nullable = false)
    private String body;

    @Column(columnDefinition = "int2 default 0")
    private short likeCount;

    @Column(columnDefinition = "int2 default 0")
    private short dislikeCount;

    @Column(nullable = false)
    private String createdBy;

    @Column(columnDefinition = "int2 default 0")
    private short readCount;
}
