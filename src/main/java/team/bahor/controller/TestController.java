package team.bahor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team.bahor.dto.responce.DataDto;
import team.bahor.exeptions.fileStore.FileStorageException;

@RestController
public class TestController {
    @GetMapping("/test/exception")
    public ResponseEntity<DataDto> testExceptionHandler() {
        throw new FileStorageException("MuhammadKomil ishladi");
    }
}
