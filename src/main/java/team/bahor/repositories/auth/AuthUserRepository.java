package team.bahor.repositories.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import team.bahor.entity.user.AuthUser;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser,String> {

    Optional<AuthUser> findByUsernameAndDeletedFalse(String username);
}
