package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.CategoryDTO;
import com.example.Bookstore.mapper.CategoryMapper;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.repository.CategoryRepository;
import com.example.Bookstore.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::mapToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return CategoryMapper.mapToCategoryDTO(category);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        if (categoryRepository.existsByName(categoryDTO.getName())) {
            throw new RuntimeException("Category already exists!");
        }
        Category saved = categoryRepository.save(CategoryMapper.mapToCategory(categoryDTO));
//        saved.setActive(true);
        return CategoryMapper.mapToCategoryDTO(saved);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        existing.setName(categoryDTO.getName());
        Category updated = categoryRepository.save(existing);
        return CategoryMapper.mapToCategoryDTO(updated);
    }

    @Override
    public void deleteCategory(Long id) {
        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        categoryRepository.delete(existing);
    }
}
