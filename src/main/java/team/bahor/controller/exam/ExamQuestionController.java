package team.bahor.controller.exam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.bahor.controller.AbstractController;
import team.bahor.dto.exam.examQuestion.ExamQuestionCreateDto;
import team.bahor.services.exam.examQuestion.ExamQuestionServiceImpl;

@RestController("/examQuestion/*")
public class ExamQuestionController extends AbstractController<ExamQuestionServiceImpl> {
    public ExamQuestionController(ExamQuestionServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "create")
    public ResponseEntity<String> create(@RequestBody ExamQuestionCreateDto dto){
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

}
