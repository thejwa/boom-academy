package team.bahor.repositories.course;

import org.springframework.data.jpa.repository.JpaRepository;
import team.bahor.entity.courses.CourseRating;
import team.bahor.repositories.base.BaseGenericRepository;

public interface CourseRatingRepository extends JpaRepository<CourseRating, String>, BaseGenericRepository {
}
