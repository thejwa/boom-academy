package team.bahor.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import team.bahor.entity.base.BaseGenericEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "user_activation_code")
@NoArgsConstructor
@AllArgsConstructor
public class UserActivationCode implements BaseGenericEntity {

    @Id
    @Column(unique = true)
    private String id;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "active_time", columnDefinition = "timestamp default now()")
    private LocalDateTime activeTime;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "activation_code", nullable = false)
    private String activationCode;

    @Column(nullable = false)
    private String email;

    @Column(name = "used_code", columnDefinition = "NUMERIC default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean usedCode;

}
