package team.bahor.validators.exam;

import org.springframework.stereotype.Component;
import team.bahor.dto.course.CourseDto;
import team.bahor.dto.exam.exam.ExamCreateDtoBegin;
import team.bahor.dto.exam.exam.ExamCreateDtoEnd;
import team.bahor.dto.exam.exam.ExamUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.exeptions.exam.*;
import team.bahor.services.course.CourseService;
import team.bahor.services.exam.exam.ExamServiceImpl;
import team.bahor.services.exam.examQuestionGeneration.ExamQuestionGenerationServiceImpl;
import team.bahor.utils.Utils;
import team.bahor.validators.base.AbstractValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class ExamValidator extends AbstractValidator<ExamCreateDtoBegin, ExamUpdateDto, String> {
    private final CourseService courseService;
    private final ExamServiceImpl examService;
    private final ExamQuestionGenerationServiceImpl examQuestionGenerationService;

    public ExamValidator(CourseService courseService, ExamServiceImpl examService, ExamQuestionGenerationServiceImpl examQuestionGenerationService) {
        this.courseService = courseService;
        this.examService = examService;
        this.examQuestionGenerationService = examQuestionGenerationService;
    }

    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ExamCreateDtoBegin examCreateDtoBegin) throws ValidationException {
        if (Objects.isNull(examCreateDtoBegin.getCourseId())) {
            throw new NotFoundExamCourseIdException("Not Found CourseId");
        }

        if (!examService.isThereCourse(examCreateDtoBegin.getCourseId())) {
            throw new NotFoundCourseException("Not found course");
        }

        if (examService.isMakeExam(examCreateDtoBegin.getCourseId())) {
            throw new AlreadySavedExamException("already saved exam");
        }

        //todo session id xato kelayapti
//        if (!examService.isCanCreateBegin(Utils.getSessionId(), examCreateDtoBegin.getCourseId())) {
//            throw new YouCannotCreateException("you cannot create");
//        }
        /*e6207c07-a6b2-4c3f-9aee-b400b0404c1f*/
        /*a3336d95-146d-4e55-ba14-0b5d6b80b199*/

        if (Objects.isNull(examCreateDtoBegin.getTitle())) {
            throw new NotFoundExamTitleException("Not Found Exam Title");
        }

    }

    @Override
    public void validOnUpdate(ExamUpdateDto cd) throws ValidationException {

    }

    public void createEnd(ExamCreateDtoEnd dto) {
        if (Objects.isNull(dto.getId())) {
            throw new NotFoundExamIdException("Not Found examId");
        }
        if (examService.isCanCreateEnd(Utils.getSessionId(), dto.getId())) {
            throw new YouCannotCreateException("you cannot create");
        }
        if (Objects.isNull(dto.getDuration()) || Objects.isNull(dto.getQuestionCounts())) {
            throw new BadCredentialsExamCreateEndException("Bad Credentials Exam Create End");
        }
        AtomicBoolean atomicBoolean =new AtomicBoolean();
        Map<String, Integer> questionCount = new HashMap<>();
        examQuestionGenerationService.getAllByExamId(dto.getId()).forEach(examQuestionGenerationDto ->
                questionCount.put(examQuestionGenerationDto.getMark(), examQuestionGenerationDto.getCount()));
        dto.getQuestionCounts().forEach((k,v)->{
            if(Objects.isNull(questionCount.get(k))||questionCount.get(k)<v){
                atomicBoolean.set(true);
            }
        });
        if (atomicBoolean.get()){
            throw new BadCredentialsExamCreateEndException("Savollar soni koplik qildi yoki birorta savolga savol soni belgilanmansiz");
        }
    }
}
