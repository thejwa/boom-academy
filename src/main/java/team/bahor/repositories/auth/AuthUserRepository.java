package team.bahor.repositories.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import team.bahor.entity.user.AuthUser;
import team.bahor.repositories.base.BaseGenericRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, String>, BaseGenericRepository {

    Optional<AuthUser> findByUsernameAndDeletedFalse(String username);

    @Transactional
    @Modifying
    @Query(value = "update main.auth_users set is_deleted = 1 where id = ?1",nativeQuery = true)
    void deleted(String id);

    @Transactional
    @Modifying
    @Query(value = "update main.auth_users set status = 100 where id = ?1",nativeQuery = true)
    void blocked(String id);

    boolean existsByEmail(String email);
}
