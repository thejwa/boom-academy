package team.bahor.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.BaseGenericEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "user_data")
@Entity
@NoArgsConstructor
public class UserData implements BaseGenericEntity {
    @Id
    private String id;

    @Column(nullable = false)
    private String userId;

    private Integer rating;
}
