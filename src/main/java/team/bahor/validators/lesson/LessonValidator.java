package team.bahor.validators.lesson;

import org.springframework.web.multipart.MultipartFile;
import team.bahor.validators.BaseGenericValidator;

import java.util.Objects;

public class LessonValidator implements BaseGenericValidator {

    public boolean checkFile(MultipartFile multipartFile){
        return Objects.requireNonNull(multipartFile.getContentType()).startsWith("video");
    }
}
