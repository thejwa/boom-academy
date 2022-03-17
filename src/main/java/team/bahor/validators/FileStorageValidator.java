package team.bahor.validators;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import team.bahor.exeptions.fileStore.FileStorageException;

@Component
public class FileStorageValidator implements BaseGenericValidator {
    public void checkVideoFile(MultipartFile multipartFile) {
        if (multipartFile.getContentType().startsWith("video")) {
        }
        else {
            throw new FileStorageException("this content invalid, please input video content");
        }
    }
}
