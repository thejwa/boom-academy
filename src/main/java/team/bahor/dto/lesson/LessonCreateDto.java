package team.bahor.dto.lesson;

import org.springframework.web.multipart.MultipartFile;
import team.bahor.dto.BaseGenericDto;

public class LessonCreateDto implements BaseGenericDto {
    MultipartFile videoFile;
}
