package team.bahor.controller.tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team.bahor.controller.AbstractController;
import team.bahor.dto.responce.DataDto;
import team.bahor.dto.tag.TagCreateDto;
import team.bahor.dto.tag.TagDto;
import team.bahor.services.tag.TagsServiceImp;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagsController extends AbstractController<TagsServiceImp> {

    public TagsController(TagsServiceImp service) {
        super(service);
    }

    @PostMapping("/create")
    public ResponseEntity<DataDto<String>> create(@RequestBody TagCreateDto dto) {
        String message = service.create(dto);
        return new ResponseEntity<>(new DataDto<>(message), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DataDto<TagDto>> get(@PathVariable String id) {
        TagDto savedCourseDto = service.get(id);
        return new ResponseEntity<>(new DataDto<>(savedCourseDto), HttpStatus.OK);
    }

    @GetMapping("/get-all/{courseId}")
    public ResponseEntity<DataDto<List<TagDto>>> getAll(@PathVariable String courseId) {
        List<TagDto> courseDtoList = service.getAllTag(courseId);
        return new ResponseEntity<>(new DataDto<>(courseDtoList), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<DataDto<Void>> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
//    public ResponseEntity<ApiResult<ErrorData>> handleException(MethodArgumentNotValidException ex) {
//        List<ErrorData> errors = new ArrayList<>();
//        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
//        fieldErrors.forEach(fieldError -> errors.add(new ErrorData(fieldError.getDefaultMessage(), fieldError.getField(), RestConstants.REQUIRED)));
//        return new ResponseEntity<>(ApiResult.errorResponse(errors), HttpStatus.BAD_REQUEST);
//    }
}
