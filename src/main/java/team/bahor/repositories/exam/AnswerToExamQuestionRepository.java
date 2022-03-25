package team.bahor.repositories.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import team.bahor.entity.exam.AnswerToExamQuestion;
import team.bahor.entity.exam.ExamQuestion;
import team.bahor.repositories.base.BaseGenericRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface AnswerToExamQuestionRepository extends JpaRepository<AnswerToExamQuestion, String>, BaseGenericRepository {
    @Transactional
    @Modifying
    @Query(value = "update AnswerToExamQuestion at set at.deleted = true where at.id = ?1")
    void deleted(String id);

    AnswerToExamQuestion getByIdAndDeletedIsFalse(String id);

    List<AnswerToExamQuestion> getByDeletedFalse();
}
