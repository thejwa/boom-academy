package team.bahor.repositories.course;

import team.bahor.entity.courses.Course;
import team.bahor.repositories.base.AbstractRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends AbstractRepository<Course, String> {

    boolean existsByIdAndCreatedBy(String id, String createdBy);

    List<Course> findAllByStatusAndDeletedFalse(Short status);

    List<Course> findAllByDeletedFalse();

    Optional<Course> findByIdAndDeletedFalse(String id);

    Optional<Course> findByIdAndCreatedByAndDeletedFalse(String id, String createdBy);
}
