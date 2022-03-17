package team.bahor.controller.course;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.bahor.controller.AbstractController;
import team.bahor.dto.course.CourseSectionCreateDto;
import team.bahor.services.course.CourseSectionService;

@RestController
@RequestMapping("/courseSection/")
public class CourseSectionController extends AbstractController<CourseSectionService> {

    public CourseSectionController(CourseSectionService service) {
        super(service);
    }

    @PostMapping("create")
    public ResponseEntity<String> create(@RequestBody CourseSectionCreateDto dto){

        service.create(dto);

        return ResponseEntity.ok("");
    }

}
