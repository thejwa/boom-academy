package team.bahor.exeptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import team.bahor.dto.responce.AppErrorDto;
import team.bahor.dto.responce.DataDto;
import team.bahor.exeptions.course.CategoryNotAvailableException;
import team.bahor.exeptions.fileStore.FileStorageException;

@ControllerAdvice("team.bahor")
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {FileStorageException.class})
    public ResponseEntity<DataDto> handleTestException(FileStorageException exception, WebRequest webRequest) {
        return new ResponseEntity<>(
                DataDto.builder()
                        .success(false)
                        .error(
                                new AppErrorDto(exception.getMessage(),
                                        webRequest,
                                        HttpStatus.FORBIDDEN, exception.getDeveloperMessage()))
                        .build(), HttpStatus.OK);
    }

    @ExceptionHandler(value = CategoryNotAvailableException.class)
    public ResponseEntity<DataDto<AppErrorDto>> handleCategoryNotAvailableException(CategoryNotAvailableException exception, WebRequest request) {
        return new ResponseEntity<>(
                DataDto.<AppErrorDto>builder()
                        .success(false)
                        .error(new AppErrorDto(
                                exception.getMessage(),
                                request,
                                HttpStatus.NO_CONTENT,
                                exception.getDeveloperMessage())).build(), HttpStatus.OK
        );

    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<DataDto> handleRuntimeException(RuntimeException exception, WebRequest request) {
        return new ResponseEntity<>(
                DataDto.builder()
                        .success(false)
                        .error(
                                new AppErrorDto(exception.getMessage(),
                                        request,
                                        HttpStatus.FORBIDDEN,
                                        exception.getMessage()))
                        .build(), HttpStatus.OK);
    }
}
