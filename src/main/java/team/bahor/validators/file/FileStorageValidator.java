package team.bahor.validators.file;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import team.bahor.exeptions.fileStore.FileStorageException;
import team.bahor.validators.base.BaseGenericValidator;

@Component
public class FileStorageValidator implements BaseGenericValidator {
    public void checkVideoFile(MultipartFile multipartFile) {
        if (!multipartFile.getContentType().startsWith("video")) {
            throw new FileStorageException("this content invalid, please input video content");
        }
    }
}
