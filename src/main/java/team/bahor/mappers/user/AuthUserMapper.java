package team.bahor.mappers.user;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import team.bahor.dto.user.UserCreateDto;
import team.bahor.dto.user.UserDto;
import team.bahor.dto.user.UserUpdateDto;
import team.bahor.entity.user.AuthUser;
import team.bahor.mappers.base.AbstractMapper;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends AbstractMapper<AuthUser, UserDto, UserCreateDto, UserUpdateDto> {
}
