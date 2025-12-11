package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.CategoryDto;
import com.example.Bookstore.model.Category;

public class CategoryMapper {

    public static CategoryDto toCategoryDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    public static Category toCategory(CategoryDto dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }
}
