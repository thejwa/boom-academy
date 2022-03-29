package team.bahor.validators.course.saved;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.bahor.dto.course.saved.SavedCourseCreateDto;
import team.bahor.dto.course.saved.SavedCourseUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.repositories.auth.AuthUserRepository;
import team.bahor.repositories.course.SavedCourseRepository;
import team.bahor.utils.Utils;
import team.bahor.validators.base.AbstractValidator;

@Component
@RequiredArgsConstructor
public class SavedCourseValidator extends AbstractValidator<SavedCourseCreateDto, SavedCourseUpdateDto, String> {

    private final SavedCourseRepository savedCourseRepository;
    private final AuthUserRepository authUserRepository;

    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(SavedCourseCreateDto dto) throws ValidationException {

    }


    public boolean validOnCreated(SavedCourseCreateDto savedCourseCreateDto) throws ValidationException {
        return savedCourseRepository.existsByCourseIdAndUserId(savedCourseCreateDto.getUserId(), savedCourseCreateDto.getCourseId());
    }

    @Override
    public void validOnUpdate(SavedCourseUpdateDto cd) throws ValidationException {

    }

    public void validOnCreatedUser(String userId){
        if (userId.equals(Utils.getSessionId()) || authUserRepository.existsByIdAuthorizated(Utils.getSessionId()))
            throw new RuntimeException("Zzzzzzzzz");
    }
}
