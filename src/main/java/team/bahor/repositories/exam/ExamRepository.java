package team.bahor.repositories.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import team.bahor.entity.exam.Exam;
import team.bahor.repositories.base.BaseGenericRepository;

public interface ExamRepository extends JpaRepository<Exam, String>, BaseGenericRepository {
}
