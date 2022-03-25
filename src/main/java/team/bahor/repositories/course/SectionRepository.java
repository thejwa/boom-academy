package team.bahor.repositories.course;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import team.bahor.entity.courses.Section;
import team.bahor.repositories.base.AbstractRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface SectionRepository extends AbstractRepository<Section, String> {

//    boolean existsByIdAndDeletedTrue(String id);
//
//    @Query(value = "select * from boom_academy.main.section s where s.is_deleted = 0", nativeQuery = true)
//    List<Section> findAllSections();

    @Query(value = "select * from boom_academy.main.section s where s.course_id = id and s.is_deleted = 0 and created_by = ?2", nativeQuery = true)
    List<Section> findAllByCourseIdAAndDelete(String id, String ownerId);

    @Query(value = "select * from boom_academy.main.section s where s.id = ?1 and s.is_deleted = 0 and created_by = ?2", nativeQuery = true)
    Optional<Section> findByNoDeletedSection(String id, String ownerId);

    @Transactional
    @Modifying
    @Query(value = "update boom_academy.main.section set position = position + 1 where course_id = ?1 and position >= ?2 and is_deleted = 0 and created_by = ?3", nativeQuery = true)
    void updatePositionSection(String courseId, short positionNew, String ownerId);

    @Transactional
    @Modifying
    @Query(value = "update boom_academy.main.section set position = position + 1 where course_id = ?1 and position >= ?2 and is_deleted = 0 and position < ?3 and created_by = ?4", nativeQuery = true)
    void updatePositionRightSection(String courseId, short positionNew, short positionDef, String ownerId);

    @Transactional
    @Modifying
    @Query(value = "update boom_academy.main.section set position = position - 1 where course_id = ?1 and position =< ?2 and is_deleted = 0 and position > ?3 and created_by = ?4", nativeQuery = true)
    void updatePositionLeftSection(String courseId, short positionNew, short positionDef, String ownerId);

    short countSectionByCourseId(String courseId);

    @Transactional
    @Modifying
    @Query(value = "update boom_academy.main.section set is_deleted = 1 where id = ?1 and created_by = ?2", nativeQuery = true)
    void deleteBySection(String sId, String ownerId);

//
}
