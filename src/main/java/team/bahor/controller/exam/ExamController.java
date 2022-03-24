package team.bahor.controller.exam;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import team.bahor.controller.AbstractController;
import team.bahor.dto.exam.exam.ExamCreateDtoBegin;
import team.bahor.services.exam.ExamServiceImpl;

@RestController("/exam/*")
public class ExamController extends AbstractController<ExamServiceImpl> {
    @Autowired
    public ExamController(ExamServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = {"create"},method = RequestMethod.GET)
    public ResponseEntity<String> create(@RequestBody ExamCreateDtoBegin dtoBegin){
        return new ResponseEntity<>(service.create(dtoBegin), HttpStatus.CREATED);
    }

    @RequestMapping(value = {"create"},method = RequestMethod.GET)
    public ResponseEntity<String> create(@RequestBody ExamCreateDtoBegin.ExamCreateDtoEnd dto){
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }


}
