package team.bahor.services.exam.examQuestionGeneration;

import org.springframework.stereotype.Service;
import team.bahor.dto.exam.examQuestionGeneration.ExamQuestionGenerationCreateDto;
import team.bahor.dto.exam.examQuestionGeneration.ExamQuestionGenerationDto;
import team.bahor.dto.exam.examQuestionGeneration.ExamQuestionGenerationUpdateDto;
import team.bahor.mappers.exam.ExamQuestionGenerationMapper;
import team.bahor.repositories.exam.ExamQuestionGenerationRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.services.exam.examQuestionGeneration.ExamQuestionGenerationService;
import team.bahor.validators.exam.ExamQuestionGenerationValidator;

import java.util.List;

@Service
public class ExamQuestionGenerationServiceImpl extends AbstractService<
        ExamQuestionGenerationRepository,
        ExamQuestionGenerationMapper,
        ExamQuestionGenerationValidator
        > implements ExamQuestionGenerationService {
    public ExamQuestionGenerationServiceImpl(ExamQuestionGenerationMapper mapper,
                                             ExamQuestionGenerationValidator validator,
                                             ExamQuestionGenerationRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(ExamQuestionGenerationCreateDto createDto) {

        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(ExamQuestionGenerationUpdateDto updateDto) {

    }

    @Override
    public ExamQuestionGenerationDto get(String id) {
        return null;
    }

    @Override
    public List<ExamQuestionGenerationDto> getAll() {
        return null;
    }

    public List<ExamQuestionGenerationDto> getAllByExamId(String id) {
        return mapper.toDto(repository.findAllByDeletedFalseAndExamId(id));
    }

}
