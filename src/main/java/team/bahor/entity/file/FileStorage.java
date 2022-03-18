package team.bahor.entity.file;

import lombok.Getter;
import lombok.Setter;
import team.bahor.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(schema = "lessons", indexes = {
        @Index(name = "file_storage_status_index", columnList = "status"),
        @Index(name = "file_storage_lessonId_index", columnList = "lessonId"),
        @Index(name = "file_storage_path_index", columnList = "path"),
        @Index(name = "file_storage_type_index", columnList = "type")
})
public class FileStorage extends Auditable {

    @Column(nullable = false)
    String lessonId;

    @Column(nullable = false)
    String path;

    @Column(nullable = false)
    String originalName;

    @Column(nullable = false)
    String generatedName;

    String type;

}
