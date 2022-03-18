package team.bahor.controller.course;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.bahor.controller.AbstractController;
import team.bahor.dto.course.CourseCreateDto;
import team.bahor.dto.course.CourseDto;
import team.bahor.dto.responce.DataDto;
import team.bahor.services.course.CourseService;


@RestController(value = "/course/")
public class CourseController extends AbstractController<CourseService> {


    public CourseController(CourseService service) {
        super(service);
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<DataDto<CourseDto>> get(@PathVariable String id) {
        return null;
    }

    @PostMapping("create")
    public ResponseEntity<DataDto<String>> create(@RequestBody CourseCreateDto dto){
        String id = service.create(dto);
        return new ResponseEntity<>(new DataDto<>(id), HttpStatus.OK);
    }

}
