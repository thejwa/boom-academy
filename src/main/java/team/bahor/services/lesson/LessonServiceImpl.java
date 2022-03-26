package team.bahor.services.lesson;

import org.springframework.stereotype.Service;
import team.bahor.mappers.lesson.LessonMapper;
import team.bahor.repositories.lesson.LessonRepository;
import team.bahor.services.base.AbstractService;
import team.bahor.validators.lesson.LessonValidator;

@Service
public class LessonServiceImpl extends AbstractService<LessonRepository, LessonMapper, LessonValidator> {
    protected LessonServiceImpl(LessonMapper mapper, LessonValidator validator, LessonRepository repository) {
        super(mapper, validator, repository);
    }


}
