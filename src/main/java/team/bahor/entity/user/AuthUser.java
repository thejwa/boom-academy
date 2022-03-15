package team.bahor.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;

@Getter
@Setter
@Table(name = "auth_users")
@Entity
@NoArgsConstructor
public class AuthUser extends Auditable {

    private String fullName;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role_id;

    private Double balance;

    private String photo_url;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;
}
