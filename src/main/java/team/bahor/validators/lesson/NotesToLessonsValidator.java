package team.bahor.validators.lesson;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.bahor.dto.lesson.note.NotesToLessonsCreateDto;
import team.bahor.dto.lesson.note.NotesToLessonsUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.validators.base.AbstractValidator;

@Component
@RequiredArgsConstructor
public class NotesToLessonsValidator extends AbstractValidator<NotesToLessonsCreateDto, NotesToLessonsUpdateDto, String> {
    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(NotesToLessonsCreateDto notesToLessonsCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(NotesToLessonsUpdateDto cd) throws ValidationException {

    }
}
