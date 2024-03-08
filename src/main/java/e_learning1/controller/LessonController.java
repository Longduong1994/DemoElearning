package e_learning1.controller;

import e_learning1.service.lesson.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/session")
public class LessonController {
    private final LessonService lessonService;

    @GetMapping("{courseId}")
    public ResponseEntity<?> getSession(@PathVariable("courseId") String courseId ){
        Long id = Long.parseLong(courseId);
        return new ResponseEntity<>(lessonService.countSessionByCourse(id), HttpStatus.OK);
    }


}
