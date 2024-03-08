package e_learning1.repository;

import e_learning1.entity.Account;
import e_learning1.entity.Category;
import e_learning1.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    Page<Course> findAllByTitleContaining(String searchName, Pageable pageable);

    Page<Course> findAllByTitleContainingAndCategory(String search, Category category,Pageable pageable);
@Query(value = "select c.* from course c join account_course ac on c.id = ac.course_id where ac.account_id =:accountId",
nativeQuery = true)
    Page<Course> findAllByUser(@Param("accountId") Long accountId, Pageable pageable);
}
