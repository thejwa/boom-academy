package team.bahor.exeptions.course;

import team.bahor.exeptions.ValidationException;

public class CourseNotFoundException extends ValidationException {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
