package e_learning1.repository;

import e_learning1.entity.Account;
import e_learning1.entity.AccountCourse;
import e_learning1.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountCourseRepository extends JpaRepository<AccountCourse,Long> {
    @Query(value = "SELECT AC.completed_lesson FROM account_course AC WHERE AC.course_id =:courseId ", nativeQuery = true)
    Long getPercentComplete(Long courseId);

}
