package team.bahor.services.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import team.bahor.dto.auth.AuthUserDto;
import team.bahor.dto.auth.SessionDto;
import team.bahor.dto.responce.AppErrorDto;
import team.bahor.dto.responce.DataDto;
import team.bahor.dto.user.UserCreateDto;
import team.bahor.dto.user.UserDto;
import team.bahor.dto.user.UserUpdateDto;
import team.bahor.entity.user.AuthUser;
import team.bahor.exeptions.user.AuthUserEmailAlreadyTakenExeption;
import team.bahor.mappers.user.AuthUserMapper;
import team.bahor.properties.ServerProperties;
import team.bahor.repositories.auth.AuthUserRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.validators.user.AuthUserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class AuthUserServiceImp extends AbstractService<
        AuthUserRepository,
        AuthUserMapper,
        AuthUserValidator> implements AuthUserService, UserDetailsService {

    private final JavaMailSender javaMailSender;
    private final ServerProperties serverProperties;
    private final ObjectMapper objectMapper;

    @Autowired
    public AuthUserServiceImp(@Lazy AuthUserMapper mapper,
                              AuthUserValidator validator,
                              AuthUserRepository repository,
                              JavaMailSender javaMailSender,
                              ServerProperties serverProperties,
                              ObjectMapper objectMapper) {
        super(mapper, validator, repository);
        this.javaMailSender = javaMailSender;
        this.serverProperties = serverProperties;
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<DataDto<SessionDto>> getToken(AuthUserDto dto) {

        try {

            HttpClient httpclient = HttpClientBuilder.create().build();
            HttpPost httppost = new HttpPost(serverProperties.getServerUrl() + "/api/login");
            byte[] bytes = objectMapper.writeValueAsBytes(dto);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            httppost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httppost.setEntity(new InputStreamEntity(byteArrayInputStream));

            HttpResponse response = httpclient.execute(httppost);

            JsonNode json_auth = objectMapper.readTree(EntityUtils.toString(response.getEntity()));

            if (json_auth.has("success") && json_auth.get("success").asBoolean()) {
                JsonNode node = json_auth.get("data");
                SessionDto sessionDto = objectMapper.readValue(node.toString(), SessionDto.class);
                return new ResponseEntity<>(new DataDto<>(sessionDto), HttpStatus.OK);
            }
            return new ResponseEntity<>(new DataDto<>(objectMapper.readValue(json_auth.get("error").toString(),
                    AppErrorDto.class)), HttpStatus.OK);

        } catch (IOException e) {
            return new ResponseEntity<>(new DataDto<>(AppErrorDto.builder()
                    .message(e.getLocalizedMessage())
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build()), HttpStatus.OK);
        }
    }

    public ResponseEntity<DataDto<SessionDto>> refreshToken(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = repository.findByUsernameAndDeletedFalse(username).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        });
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities("ROLE_" + user.getRole())
                .accountLocked(false)
                .accountExpired(false)
                .disabled(false)
                .credentialsExpired(false)
                .build();
    }


    public void blocked(String id) {
        repository.blocked(id);
    }

    @Override
    public String create(UserCreateDto createDto) {

        AuthUser authUser = repository.existsByEmailOrUsername(createDto.getEmail(), createDto.getUsername());
        if (Objects.nonNull(authUser))
            throw new AuthUserEmailAlreadyTakenExeption("Bad request !!!");

        Random random = new Random();
        int ints = random.nextInt(10001, 99999);
        System.out.println("random = " + ints);

        Boolean sendEmail = sendEmail(createDto.getEmail(), random.toString());

        if (sendEmail)
            return "Account created. You can activated account with email !!!";
        return "Email no Created";
    }

    @Override
    public void delete(String id) {
        repository.deleted(id);
    }

    @Override
    public void update(UserUpdateDto updateDto) {

    }

    @Override
    public UserDto get(String id) {
        return null;
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    public Boolean sendEmail(String sendingEmail, String key) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("boom_academy@gmail.com");
            message.setTo(sendingEmail);
            message.setSubject("SECRET REGISTRATION KEY");
            message.setText(key + " this is the secret key for you to register from the system please do not give it to anyone");
            javaMailSender.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

