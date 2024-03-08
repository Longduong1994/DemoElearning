package e_learning1.repository;

import e_learning1.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {
    @Query(value = "SELECT count(*) FROM session WHERE session.course_id = :courseId", nativeQuery = true)
    int countByCourse(@Param("courseId") Long courseId);

    @Query(value = "SELECT count (*) FROM session  WHERE session.course_id = :courseId and completed = 'true'" , nativeQuery = true)
    int countByCourseCompleted(@Param("courseId") Long courseId);
}
