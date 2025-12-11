package com.example.Bookstore.dto;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.Category;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
    private boolean isActive;

    private List<Long> bookIds;

    public static CategoryDTO fromEntity(Category category) {
        if (category == null) return null;

        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setActive(category.isActive());

        dto.setBookIds(
                category.getBooks().stream()
                        .map(Book::getId)
                        .toList()
        );

        return dto;
    }

    public Category toEntity(List<Book> books) {
        Category category = new Category();
        category.setId(this.id);
        category.setName(this.name);
        category.setDescription(this.description);
        category.setActive(this.isActive);

        if (books != null) {
            books.forEach(book -> book.setCategory(category));
            category.setBooks(books);
        }

        return category;
    }
}
