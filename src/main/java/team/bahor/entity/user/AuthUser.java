package team.bahor.entity.user;

import lombok.*;
import team.bahor.entity.base.Auditable;
import team.bahor.enums.Role;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table(schema = "auth_users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser extends Auditable {

    private String fullName;

    @Column(nullable = false,unique = true)
    private String username;


    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    private Double balance;

    private String photo_url;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Builder(builderMethodName = "childBuilder")

    public AuthUser(String id, LocalDateTime createdAt, LocalDateTime updatedAt, boolean deleted, Short status, String fullName, String username, String password, Role role, Double balance, String photo_url, String email, String phone) {
        super(id, createdAt, updatedAt, deleted, status);
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.balance = balance;
        this.photo_url = photo_url;
        this.email = email;
        this.phone = phone;
    }
}
