package team.bahor.sercices.user;

import team.bahor.dto.user.UserCreateDto;
import team.bahor.dto.user.UserDto;
import team.bahor.dto.user.UserUpdateDto;
import team.bahor.entity.user.AuthUser;
import team.bahor.sercices.base.GenericCrudService;

public interface AuthUserService extends GenericCrudService<
        UserDto,
        UserCreateDto,
        UserUpdateDto,
        String
        > {

    }