package team.bahor.exeptions.exam;

import team.bahor.exeptions.ValidationException;

public class BadCredentialsExamCreateEndException extends ValidationException {
    public BadCredentialsExamCreateEndException(String message) {
        super(message);
    }

    public BadCredentialsExamCreateEndException(String message, Throwable cause) {
        super(message, cause);
    }
}
