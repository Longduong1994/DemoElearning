package e_learning1.controller;

import e_learning1.exception.NotFoundException;
import e_learning1.service.course.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping()
        public ResponseEntity<?> getCourse(@RequestParam(defaultValue = "") String searchName,
                                       @RequestParam(defaultValue = "0") String id,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "4") int limit) throws NotFoundException {
        Long categoryId;
        if (id.equals("0")){
            categoryId= null;
        }else {
            categoryId = Long.parseLong(id);
        }
        return new  ResponseEntity<>(courseService.findCourse(searchName, categoryId,page,limit), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCourseByUserId(@PathVariable("id") String userId,
                                             @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "4") int limit){
        Long id = Long.parseLong(userId);
        return new ResponseEntity<>(courseService.getCourseParticipating(id,page,limit), HttpStatus.OK);
    }
}
