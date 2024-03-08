package e_learning1.service.course;

import e_learning1.dto.response.CourseParticipating;
import e_learning1.dto.response.CourseResponse;
import e_learning1.exception.NotFoundException;
import org.springframework.data.domain.Page;

public interface CourseService {
    Page<CourseResponse> findCourse(String searchName, Long categoryId, int page, int limit) throws NotFoundException;

    Page<CourseParticipating> getCourseParticipating(Long accountId, int page, int limit);
}
