package team.bahor.repositories.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import team.bahor.entity.exam.ExamQuestion;
import team.bahor.repositories.base.BaseGenericRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, String>, BaseGenericRepository {
    @Transactional
    @Modifying
    @Query(value = "update ExamQuestion eq set eq.deleted = true where eq.id = ?1")
    void deleted(String id);

    ExamQuestion getByIdAndDeletedIsFalse(String id);

    List<ExamQuestion> getByDeletedFalse();
}
