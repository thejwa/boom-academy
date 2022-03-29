package team.bahor.repositories.course;

import org.springframework.data.jpa.repository.Query;
import team.bahor.entity.courses.Course;
import team.bahor.repositories.base.AbstractRepository;

import java.util.Optional;

import java.util.List;

public interface CourseRepository extends AbstractRepository<Course, String> {

    boolean existsByIdAndCreatedBy(String id, String createdBy);

    @Query(value = "select * from boom_academy.main.courses where id = ?1 and status = 0 and is_deleted = 0", nativeQuery = true)
    Optional<Course> activeThisCourse(String id);

    @Query(value = "select sum(rating)/count(*) from boom_academy.main.courses where created_by = ?1 and is_deleted = 0", nativeQuery = true)
    float courseRatingActive(String id);

    List<Course> findAllByStatusAndDeletedFalse(Short status);

    List<Course> findAllByDeletedFalse();

    Optional<Course> findByIdAndDeletedFalse(String id);

    Optional<Course> findByIdAndCreatedByAndDeletedFalse(String id, String createdBy);
}
