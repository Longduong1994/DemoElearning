package e_learning1.service.category;

import e_learning1.entity.Category;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Page<Category> findAll(int page, int limit);
}
