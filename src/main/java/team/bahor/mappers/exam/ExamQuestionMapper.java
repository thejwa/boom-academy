package team.bahor.mappers.exam;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import team.bahor.dto.exam.examQuestion.ExamQuestionCreateDto;
import team.bahor.dto.exam.examQuestion.ExamQuestionDto;
import team.bahor.dto.exam.examQuestion.ExamQuestionUpdateDto;
import team.bahor.entity.exam.ExamQuestion;
import team.bahor.mappers.base.AbstractMapper;

@Component
@Mapper(componentModel = "spring")
public interface ExamQuestionMapper extends AbstractMapper<
        ExamQuestion,
        ExamQuestionDto,
        ExamQuestionCreateDto,
        ExamQuestionUpdateDto
        > {
    @Override
    @Mapping(target = "answers",ignore = true)
    @Mapping(target = "type",ignore = true)
    ExamQuestionDto toDto(ExamQuestion entity);
}
