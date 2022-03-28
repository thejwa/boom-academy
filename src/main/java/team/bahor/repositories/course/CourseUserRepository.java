package team.bahor.repositories.course;

import org.springframework.data.jpa.repository.JpaRepository;
import team.bahor.entity.courses.CourseUser;

public interface CourseUserRepository extends JpaRepository<CourseUser, String> {

    boolean existsByCourseIdAndUserIdAndStatus(String courseId, String userId, Short status);
}
