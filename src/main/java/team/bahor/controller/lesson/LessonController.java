package team.bahor.controller.lesson;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team.bahor.controller.AbstractController;
import team.bahor.dto.lesson.LessonCreateDto;
import team.bahor.dto.responce.DataDto;
import team.bahor.services.lesson.LessonServiceImpl;

@RestController
public class LessonController extends AbstractController<LessonServiceImpl> {
    public LessonController(LessonServiceImpl service) {
        super(service);
    }

    @PostMapping(PATH + "/lesson/create")
    public ResponseEntity<DataDto<String>> create(@RequestBody LessonCreateDto dto){
        return new ResponseEntity<>(new DataDto<>("sdlfkjsjlf"), HttpStatus.OK);
    }

}
