package team.bahor.repositories.exam;

import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import team.bahor.entity.exam.ExamQuestionGeneration;
import team.bahor.mappers.base.AbstractMapper;
import team.bahor.repositories.base.BaseGenericRepository;

@Component
@Mapper(componentModel = "spring")
public interface ExamQuestionGenerationRepository extends JpaRepository<ExamQuestionGeneration, String>, BaseGenericRepository {
}
