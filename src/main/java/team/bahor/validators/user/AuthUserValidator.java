package team.bahor.validators.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.bahor.dto.user.UserCreateDto;
import team.bahor.dto.user.UserUpdateDto;
import team.bahor.entity.user.UserActivationCode;
import team.bahor.exeptions.ValidationException;
import team.bahor.repositories.auth.UserActivationCodeRepository;
import team.bahor.validators.AbstractValidator;

@Component
@RequiredArgsConstructor
public class AuthUserValidator extends AbstractValidator<UserCreateDto, UserUpdateDto, String> {

    private final UserActivationCodeRepository userActivationCodeRepository;

    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(UserCreateDto userCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(UserUpdateDto cd) throws ValidationException {

    }

    public void checksActivationCode(String activationCode, String email) {
        UserActivationCode userActivationCode = userActivationCodeRepository.checkingCode(activationCode, email);

    }
}

