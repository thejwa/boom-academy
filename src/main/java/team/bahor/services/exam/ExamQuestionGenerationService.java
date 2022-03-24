package team.bahor.services.exam;

import team.bahor.mappers.exam.ExamQuestionGenerationMapper;
import team.bahor.repositories.exam.ExamQuestionGenerationRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.validators.exam.ExamQuestionGenerationValidator;

public class ExamQuestionGenerationService extends AbstractService<
        ExamQuestionGenerationRepository,
        ExamQuestionGenerationMapper,
        ExamQuestionGenerationValidator
        > {
    public ExamQuestionGenerationService(ExamQuestionGenerationMapper mapper,
                                         ExamQuestionGenerationValidator validator,
                                         ExamQuestionGenerationRepository repository) {
        super(mapper, validator, repository);
    }
}
