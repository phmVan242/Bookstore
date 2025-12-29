package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.CategoryDTO;
import com.example.Bookstore.model.Category;

public class CategoryMapper {

    public static CategoryDTO mapToCategoryDTO(Category category) {
        if (category == null) return null;

        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setActive(category.getIsActive());

        // số lượng sách trong category
        if (category.getBooks() != null) {
            dto.setBookCount(category.getBooks().size());
        } else {
            dto.setBookCount(0);
        }

        return dto;
    }

    public static Category mapToCategory(CategoryDTO dto) {
        if (dto == null) return null;

        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
//        category.setIsActive(dto.getActive());
        category.setIsActive(
                dto.getActive() != null ? dto.getActive() : true
        );
        return category;
    }
}
