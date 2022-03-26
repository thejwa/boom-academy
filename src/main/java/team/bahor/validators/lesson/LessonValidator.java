package team.bahor.validators.lesson;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import team.bahor.dto.lesson.LessonCreateDto;
import team.bahor.dto.lesson.LessonUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.exeptions.course.CategoryNotAvailableException;
import team.bahor.validators.base.AbstractValidator;

import java.util.Objects;

@Component
public class LessonValidator extends AbstractValidator<LessonCreateDto, LessonUpdateDto, String> {

    public boolean checkFile(MultipartFile multipartFile) {
        return Objects.requireNonNull(multipartFile.getContentType()).startsWith("video");
    }

    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(LessonCreateDto dto) throws ValidationException, CategoryNotAvailableException {

    }

    @Override
    public void validOnUpdate(LessonUpdateDto cd) throws ValidationException {

    }
}
