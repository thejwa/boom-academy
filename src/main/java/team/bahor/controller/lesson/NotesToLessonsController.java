package team.bahor.controller.lesson;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.bahor.controller.AbstractController;
import team.bahor.services.lesson.notes.NotesToLessonsServiceImpl;

@RestController
@RequestMapping("/notes-to-lessons")
public class NotesToLessonsController extends AbstractController<NotesToLessonsServiceImpl> {
    public NotesToLessonsController(NotesToLessonsServiceImpl service) {
        super(service);
    }
}
