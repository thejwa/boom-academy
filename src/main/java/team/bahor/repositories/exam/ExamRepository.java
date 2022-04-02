package team.bahor.repositories.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    @Modifying
    @Query(value = "update Exam set duration = :#{#examDto.duration},maxMark = :#{#examDto.maxMark},questionCount = :#{#examDto.questionCount},status = 301 where id= :#{#examDto.id}")
    void update(ExamDto examDto);


    @Transactional
    @Modifying
    @Query(value = "update Exam eq set eq.deleted = true where eq.id = ?1")
    void deleted(String id);

    @Query("select e from Exam e where e.id = ?1 and e.deleted = false")
    Exam getByIdAndDeletedIsFalse(String id);

    List<Exam> getByDeletedFalse();

    @Transactional
    @Modifying
    @Query(value = "update Exam eq set eq.status = 302 where  eq.id = ?1")
    void block(String id);


    @Query(value = "select e.duration from boom_academy.main.exam e where e.is_deleted = 0 and e.id = ?1", nativeQuery = true)
    Long getByIdForDuration(String examId);

//    @Query(value = "select e.title from boom_academy.main.exam  e where e.is_deleted = 0 and e.id = ?1", nativeQuery = true)
//    String getByIdForTitle(String examId);

    @Query(value = "select e.* from boom_academy.main.exam e inner join boom_academy.main.exam_user eu on e.id = eu.exam_id where eu.id = ?1", nativeQuery = true)
    Exam getByExamUserId(String examUserId);


    //    @Procedure(procedureName = "boom_academy.main.finish")
    @Query(value = "select main.finish_exam( ?1 )", nativeQuery = true)
    String finish(String examUserId);

    @Query(value = "select  exists(select * from main.exam where is_deleted = 0 and course_id = ?1 )", nativeQuery = true)
    boolean isMakeExam(String courseId);

    @Query(value = "select exists(select  * from main.courses c where c.created_by = ?1 and id = ?2)", nativeQuery = true)
    boolean isCanCreateBegin(String sessionId, String courseId);

    @Query(value = "select exists(select e.id from main.exam e inner join main.courses c on e.course_id = c.id where e.id = ?2 and c.created_by = ?1)", nativeQuery = true)
    boolean isCanCreateEnd(String sessionId, String examId);

    @Query(value = "select exists(select * from  main.courses where id = ?1 and is_deleted = 0)", nativeQuery = true)
    boolean isThereCourse(String courseId);
}
