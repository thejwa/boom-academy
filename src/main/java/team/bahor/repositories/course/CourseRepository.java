package team.bahor.repositories.course;

import team.bahor.entity.courses.Course;
import team.bahor.repositories.base.AbstractRepository;

public interface CourseRepository extends AbstractRepository<Course,String> {

    boolean existsByIdAndCreatedBy(String id, String createdBy);
}
