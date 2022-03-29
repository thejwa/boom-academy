package team.bahor.repositories.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import team.bahor.entity.courses.CourseUser;

public interface CourseUserRepository extends JpaRepository<CourseUser, String> {

    @Query(value = "select * from boom_academy.main.course_user where course_id = ?1 and user_id = ?2 and status = 0", nativeQuery = true)
    CourseUser findByCourseIdAndUserIdAndStatus(String courseId, String userId);
}
