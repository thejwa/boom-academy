package team.bahor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import team.bahor.dto.course.CourseDto;
import team.bahor.services.CourseService;

@RestController(value = "/course/")
public class CourseController extends AbstractController<CourseService> {

    public CourseController(CourseService service) {
        super(service);
    }

    @GetMapping(value = "get/{id}")
    public CourseDto get(@PathVariable String id){
        return service.get(id);
    }
}
