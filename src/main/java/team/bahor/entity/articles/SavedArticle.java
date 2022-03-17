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
@Table(name = "saved_articles", indexes = {
        @Index(name = "alkfjalsdjflaksajlsjdfladsjflkd", columnList = "articleId"),
        @Index(name = "dsd2o4rfhajklqw", columnList = "userId")
})
@Entity
@NoArgsConstructor
public class SavedArticle extends Auditable {
    @Column(nullable = false)
    private String articleId;

    @Column(nullable = false)
    private String userId;

}
