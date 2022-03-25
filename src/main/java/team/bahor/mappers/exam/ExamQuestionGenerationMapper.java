package team.bahor.mappers.exam;

import team.bahor.dto.exam.examQuestionGeneration.ExamQuestionGenerationCreateDto;
import team.bahor.dto.exam.examQuestionGeneration.ExamQuestionGenerationDto;
import team.bahor.dto.exam.examQuestionGeneration.ExamQuestionGenerationUpdateDto;
import team.bahor.entity.exam.ExamQuestionGeneration;
import team.bahor.mappers.base.AbstractMapper;
import team.bahor.mappers.base.BaseGenericMapper;

public interface ExamQuestionGenerationMapper extends AbstractMapper<
        ExamQuestionGeneration,
        ExamQuestionGenerationDto,
        ExamQuestionGenerationCreateDto,
        ExamQuestionGenerationUpdateDto
        > {
}
