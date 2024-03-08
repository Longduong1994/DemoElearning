package e_learning1.service.lesson;

import e_learning1.repository.LessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    @Override
    public int countSessionByCourse(Long courseId) {
        return lessonRepository.countByCourse(courseId);
    }

}
