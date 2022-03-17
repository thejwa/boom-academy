package team.bahor.controller.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import team.bahor.controller.AbstractController;
import team.bahor.dto.auth.AuthUserDto;
import team.bahor.dto.auth.SessionDto;
import team.bahor.dto.responce.DataDto;
import team.bahor.sercices.user.AuthUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("auth/*")
public class AuthUserController extends AbstractController<AuthUserService> {

    public AuthUserController(AuthUserService service) {
        super(service);
    }

    @RequestMapping(value = PATH+"/auth/token",method = RequestMethod.POST)
    public ResponseEntity<DataDto<SessionDto>> token(@RequestBody AuthUserDto dto){
        return service.getToken(dto);
    }

    @RequestMapping(value = PATH+"/auth/refresh-token",method = RequestMethod.POST)
    public ResponseEntity<DataDto<SessionDto>> refreshToken(HttpServletRequest request, HttpServletResponse response){
        return service.refreshToken(request,response);
    }

}
