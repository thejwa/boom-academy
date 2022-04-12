package team.bahor.repositories.lesson;

import org.springframework.data.jpa.repository.Query;
import team.bahor.entity.lesson.Lesson;
import team.bahor.repositories.base.AbstractRepository;

import java.util.Optional;

public interface LessonRepository extends AbstractRepository<Lesson, String> {

    @Query(value = "select * from boom_academy.main.lesson where id = ?1 and is_deleted = 0 and status = 0", nativeQuery = true)
    Optional<Lesson> findByLessonId(String id);

}
