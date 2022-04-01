package team.bahor.exeptions.tags;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class TagForbiddenException extends RuntimeException{
    public TagForbiddenException(String message){
        super(message);
    }
}