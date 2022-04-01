package team.bahor.repositories.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import team.bahor.entity.tag.Tags;
import team.bahor.repositories.base.BaseGenericRepository;

public interface TagsRepository extends JpaRepository<Tags, String>, BaseGenericRepository {
}
