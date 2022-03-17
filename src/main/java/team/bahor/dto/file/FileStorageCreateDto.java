package team.bahor.dto.file;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
public class FileStorageCreateDto {

    String lessonId;

    MultipartFile file;

}
