package e_learning1.service.category;

import e_learning1.entity.Category;
import e_learning1.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public Page<Category> findAll(int page, int limit) {
        return categoryRepository.findAll(PageRequest.of(page, limit));
    }
}
