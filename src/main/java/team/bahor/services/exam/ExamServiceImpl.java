package team.bahor.services.exam;

import org.springframework.stereotype.Service;
import team.bahor.dto.exam.exam.ExamCreateDtoBegin;
import team.bahor.dto.exam.exam.ExamDto;
import team.bahor.dto.exam.exam.ExamUpdateDto;
import team.bahor.entity.exam.Exam;
import team.bahor.mappers.exam.ExamMapper;
import team.bahor.repositories.exam.ExamRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.validators.exam.ExamValidator;

import java.util.List;
@Service
public class ExamServiceImpl extends AbstractService<
        ExamRepository,
        ExamMapper,
        ExamValidator
        > implements ExamService {
    public ExamServiceImpl(ExamMapper mapper, ExamValidator validator, ExamRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(ExamCreateDtoBegin createDto) {
        validator.validOnCreate(createDto);
        Exam exam = mapper.fromCreateDto(createDto);
        exam.setStatus((short) 300);
        return repository.save(exam).getId();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(ExamUpdateDto updateDto) {

    }

    @Override
    public ExamDto get(String id) {
        return null;
    }

    @Override
    public List<ExamDto> getAll() {
        return null;
    }

    public String create(ExamCreateDtoBegin.ExamCreateDtoEnd dto) {
        return null;
    }
}
