package team.bahor.exeptions.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class SectionNotFoundExeption extends RuntimeException {
    SectionNotFoundExeption(String message) {
        super(message);
    }
}