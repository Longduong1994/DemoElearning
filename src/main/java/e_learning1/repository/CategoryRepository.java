package e_learning1.repository;

import e_learning1.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository  extends JpaRepository<Category,Long> {
    Page<Category> findAll(Pageable pageable);
}
