package team.bahor.repositories;

import org.springframework.stereotype.Repository;
import team.bahor.entity.file.FileStorage;
import team.bahor.repositories.base.AbstractRepository;

import java.util.Optional;

@Repository
public interface FileStorageRepository extends AbstractRepository<FileStorage, String> {

    Optional<FileStorage> findByIdAndDeletedFalse(String id);
}
