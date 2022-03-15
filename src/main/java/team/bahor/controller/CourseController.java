package team.bahor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import team.bahor.sercices.CourseService;


public class CourseController extends AbstractController<CourseService> {

    public CourseController(CourseService service) {
        super(service);
    }

}
