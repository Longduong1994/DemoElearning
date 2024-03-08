package e_learning1.service.lesson;

public interface LessonService {
    int countSessionByCourse(Long courseId);

    int percentComplete(Long courseId);
}
