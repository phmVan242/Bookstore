package com.example.Bookstore.service;

import com.example.Bookstore.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(Long id);
    CategoryDTO createCategory(CategoryDTO categoryDto);
    CategoryDTO updateCategory(Long id, CategoryDTO categoryDto);
    void deleteCategory(Long id);
}
