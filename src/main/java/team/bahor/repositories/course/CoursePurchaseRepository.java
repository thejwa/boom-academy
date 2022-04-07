package team.bahor.repositories.course;

import org.springframework.data.jpa.repository.JpaRepository;
import team.bahor.entity.courses.CoursePurchaseHistory;
import team.bahor.repositories.base.BaseGenericRepository;

public interface CoursePurchaseRepository extends JpaRepository<CoursePurchaseHistory, String>, BaseGenericRepository {
}
