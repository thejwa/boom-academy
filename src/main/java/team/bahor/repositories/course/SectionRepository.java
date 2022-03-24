package team.bahor.repositories.course;

import org.springframework.stereotype.Repository;
import team.bahor.entity.courses.Section;
import team.bahor.repositories.base.AbstractRepository;

@Repository
public interface SectionRepository extends AbstractRepository<Section, String> {

}
