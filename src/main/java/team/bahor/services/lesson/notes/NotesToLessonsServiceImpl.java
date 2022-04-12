package team.bahor.services.lesson.notes;

import org.springframework.stereotype.Service;
import team.bahor.dto.lesson.note.NotesToLessonsCreateDto;
import team.bahor.dto.lesson.note.NotesToLessonsDto;
import team.bahor.dto.lesson.note.NotesToLessonsUpdateDto;
import team.bahor.mappers.lesson.NotesToLessonsMapper;
import team.bahor.repositories.lesson.NotesToLessonsRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.validators.lesson.NotesToLessonsValidator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class NotesToLessonsServiceImpl extends AbstractService<
        NotesToLessonsRepository,
        NotesToLessonsMapper,
        NotesToLessonsValidator> implements NotesToLessonsService {

    protected NotesToLessonsServiceImpl(NotesToLessonsMapper mapper, NotesToLessonsValidator validator, NotesToLessonsRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(NotesToLessonsCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(NotesToLessonsUpdateDto updateDto) {

    }

    @Override
    public NotesToLessonsDto get(String id) {
        return null;
    }

    @Override
    public List<NotesToLessonsDto> getAll() {
        return null;
    }
}
