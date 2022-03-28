package team.bahor.controller.course;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.bahor.controller.AbstractController;
import team.bahor.dto.course.CourseCreateDto;
import team.bahor.dto.course.CourseDto;
import team.bahor.dto.responce.DataDto;
import team.bahor.services.course.CourseService;


@RestController("/course/")
public class CourseController extends AbstractController<CourseService> {

    public CourseController(CourseService service) {
        super(service);
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<DataDto<CourseDto>> get(@PathVariable String id) {
        CourseDto courseDto = service.get(id);
        return new ResponseEntity<>(new DataDto<>(courseDto), HttpStatus.OK);
    }

    @PutMapping("activated/{id}")
    public ResponseEntity<DataDto<String>> activatedCourse(@PathVariable String id) {
        service.activated(id);
        return new ResponseEntity<>(new DataDto<>("activated"), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<DataDto<String>> create(@RequestBody CourseCreateDto dto) {
        String id = service.create(dto);
        return new ResponseEntity<>(new DataDto<>(id), HttpStatus.OK);
    }

}
