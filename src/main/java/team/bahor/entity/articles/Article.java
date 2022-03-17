package team.bahor.entity.articles;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "articles", indexes = @Index(name = "articleuserindexsjs", columnList = "created_by"))
@Entity
@NoArgsConstructor
public class Article extends Auditable {
    @Column(nullable = false)
    private String body;

    @Column(columnDefinition = "integer default 0")
    private Integer likeCount;

    @Column(columnDefinition = "integer default 0")
    private Integer dislikeCount;

    @Column(nullable = false, name = "created_by")
    private String createdBy;

    @Column(columnDefinition = "integer default 0")
    private Integer readCount;
}
