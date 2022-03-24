package team.bahor.mappers.exam;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import team.bahor.dto.exam.ExamCreateDtoBegin;
import team.bahor.dto.exam.ExamDto;
import team.bahor.dto.exam.ExamUpdateDto;
import team.bahor.entity.exam.Exam;
import team.bahor.mappers.base.AbstractMapper;

@Component
@Mapper(componentModel = "spring")
public interface ExamMapper extends AbstractMapper<Exam, ExamDto, ExamCreateDtoBegin, ExamUpdateDto> {

}
