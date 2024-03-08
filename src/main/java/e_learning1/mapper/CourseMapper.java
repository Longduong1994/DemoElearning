package e_learning1.mapper;

import e_learning1.dto.response.CourseParticipating;
import e_learning1.dto.response.CourseResponse;
import e_learning1.entity.AccountCourse;
import e_learning1.entity.Course;
import e_learning1.repository.AccountCourseRepository;
import e_learning1.repository.LessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseMapper {
    private final LessonRepository lessonRepository;
    private final AccountCourseRepository accountCourseRepository;

    public CourseResponse toResponse(Course course){
        int unit = lessonRepository.countByCourse(course.getId());
        return CourseResponse.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .image(course.getImage())
                .units(unit).build();
    }


    public CourseParticipating toResponseParticipating(Course course){
        int unit = lessonRepository.countByCourse(course.getId());
        Long completed = accountCourseRepository.getPercentComplete(course.getId());
        return CourseParticipating.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .image(course.getImage())
                .percent(completed*100/unit).build();
    }
}
