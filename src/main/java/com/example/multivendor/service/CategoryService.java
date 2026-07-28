package com.example.multivendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.multivendor.entity.Category;
import com.example.multivendor.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
    private CategoryRepository repo;

    public List<Category> getAllCategory() {
        return repo.findAll();
    }

    public Category save(Category category) {
        return repo.save(category);
    }

    public Category getCategoryById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category updateCategory(Long id, Category category) {

        Category existingCategory = getCategoryById(id);

        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setDescription(category.getDescription());

        return repo.save(existingCategory);
    }

    public String deleteCategory(Long id) {
        repo.deleteById(id);
        return "Delete Successfully";
    }
}
