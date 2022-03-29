package team.bahor.repositories.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import team.bahor.entity.courses.SavedCourse;
import team.bahor.repositories.base.BaseGenericRepository;

import javax.transaction.Transactional;

public interface SavedCourseRepository extends JpaRepository<SavedCourse, String>, BaseGenericRepository {

    @Query(value = "select * from boom_academy.main.saved_courses where user_id = ?1 and course_id = ?2 and is_deleted = 0 and  status = 0", nativeQuery = true)
    boolean existsByCourseIdAndUserId(String userId, String courseId);

    @Transactional
    @Modifying
    @Query(value = "update boom_academy.main.saved_courses set is_deleted = 1 where user_id = ?1 and course_id = ?2", nativeQuery = true)
    void deleteThisUserSavedCourse(String userId, String courseId);
}
