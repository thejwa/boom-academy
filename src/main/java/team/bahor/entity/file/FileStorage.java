package team.bahor.entity.file;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import team.bahor.entity.base.Auditable;

@Getter
@Setter
public class FileStorage extends Auditable {

    String lessonId;
    MultipartFile file;

}
