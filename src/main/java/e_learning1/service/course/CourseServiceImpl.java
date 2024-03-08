package e_learning1.service.course;

import e_learning1.dto.response.CourseParticipating;
import e_learning1.dto.response.CourseResponse;
import e_learning1.entity.Category;
import e_learning1.entity.Course;
import e_learning1.exception.NotFoundException;
import e_learning1.mapper.CourseMapper;
import e_learning1.repository.CategoryRepository;
import e_learning1.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final CourseMapper courseMapper;
    @Override
    public Page<CourseResponse> findCourse(String searchName, Long categoryId,int page, int limit) throws NotFoundException {
        if(categoryId == null){
            return courseRepository.findAllByTitleContaining(searchName, PageRequest.of(page, limit))
                    .map(courseMapper::toResponse);
        }else {
            Optional<Category> category = categoryRepository.findById(categoryId);
            if (category.isPresent()){
                return courseRepository.findAllByTitleContainingAndCategory(searchName,category.get(), PageRequest.of(page, limit))
                        .map(courseMapper::toResponse);
            }
            throw new NotFoundException("Không tìm thấy danh mục");
        }

    }

    @Override
    public Page<CourseParticipating> getCourseParticipating(Long accountId, int page, int limit) {
        Page<Course> courses = courseRepository.findAllByUser(accountId, PageRequest.of(page, limit));
        return courses.map(courseMapper::toResponseParticipating);
    }
}
