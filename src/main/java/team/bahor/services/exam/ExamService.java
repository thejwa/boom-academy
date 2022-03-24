package team.bahor.services.exam;

import team.bahor.dto.exam.ExamCreateDtoBegin;
import team.bahor.dto.exam.ExamDto;
import team.bahor.dto.exam.ExamUpdateDto;
import team.bahor.services.base.GenericCrudService;

public interface ExamService extends GenericCrudService<
        ExamDto,
        ExamCreateDtoBegin,
        ExamUpdateDto,
        String
        > {
}
