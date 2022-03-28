package team.bahor.controller.course;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.bahor.controller.AbstractController;
import team.bahor.dto.course.rating.CourseRatingCreateDto;
import team.bahor.dto.responce.DataDto;
import team.bahor.services.course.rating.CourseRatingServiceImp;

@RestController
@RequestMapping("/course-rating")
public class CourseRatingController extends AbstractController<CourseRatingServiceImp> {
    public CourseRatingController(CourseRatingServiceImp service) {
        super(service);
    }

    @PostMapping("/create")
    public ResponseEntity<DataDto<String>> create(@RequestBody CourseRatingCreateDto dto) {
        String message = service.create(dto);
        return new ResponseEntity<>(new DataDto<>(message), HttpStatus.OK);
    }

}
