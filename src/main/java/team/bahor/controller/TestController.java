package team.bahor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team.bahor.dto.responce.DataDto;
import team.bahor.exeptions.fileStore.FileStorageException;
import team.bahor.utils.Utils;

@RestController
public class TestController {
    @GetMapping("/test/exception")
    public ResponseEntity<DataDto> testExceptionHandler() {
        throw new FileStorageException("MuhammadKomil ishladi");
    }

    @GetMapping("/test/token")
    public ResponseEntity<DataDto<String>> testToken() {
        System.out.println("Utils.getSessionId() = " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return new ResponseEntity<>(new DataDto<>(Utils.getSessionId()), HttpStatus.OK);
    }


    @GetMapping("test/auth")
    public ResponseEntity<Void> test(){
        System.out.println(Utils.sessionHasRole("admin"));
        System.out.println(Utils.sessionHasRole("admin"));
        System.out.println(Utils.sessionHasRole("admin"));
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    @GetMapping("/test/auth")

}
