package team.bahor.repositories.course;

import org.springframework.stereotype.Repository;
import team.bahor.entity.courses.CourseSection;
import team.bahor.repositories.base.AbstractRepository;

@Repository
public interface CourseSectionRepository extends AbstractRepository<CourseSection,String> {

}
