package team.bahor.repositories.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import team.bahor.entity.exam.ExamQuestionGeneration;
import team.bahor.repositories.base.BaseGenericRepository;

import java.util.List;


public interface ExamQuestionGenerationRepository extends JpaRepository<ExamQuestionGeneration, String>, BaseGenericRepository {
    List<ExamQuestionGeneration> findAllByDeletedFalseAndExamId(String id);
}
