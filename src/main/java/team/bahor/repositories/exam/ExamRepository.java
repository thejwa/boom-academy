package team.bahor.repositories.exam;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import team.bahor.dto.exam.exam.ExamDto;
import team.bahor.entity.exam.Exam;
import team.bahor.repositories.base.BaseGenericRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ExamRepository extends JpaRepository<Exam, String>, BaseGenericRepository {

    Optional<Exam> findByIdAndDeletedFalse(String id);

    List<Exam> findAllByDeletedFalse();

    @Transactional
    @Qualifier
    @Query(value = "update Exam set duration = #{#examDto.duration},maxMark = #{#examDto.maxMark},questionCount = #{#examDto.questionCount},status = 0 where id= #{#examDto.id}")
    void update(ExamDto examDto);
}
