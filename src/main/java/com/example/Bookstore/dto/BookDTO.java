package com.example.Bookstore.dto;

import com.example.Bookstore.model.Book;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private Long id;

//    @NotBlank(message = "Book title is required")
    @Size(min = 2, max = 255, message = "Book title must be between 2 and 255 characters")
    private String title;

    private String author;

    private String description;

    @NotNull(message = "Original price is required")
    @Min(value = 0, message = "Original price cannot be negative")
    private Double originalPrice;

    @Min(value = 0, message = "Sale price cannot be negative")
    private Double salePrice;

    @NotNull(message = "Stock quantity is required")
    @Min(value = 0, message = "Stock quantity cannot be negative")
    private Integer stockQuantity;

    private Integer soldQuantity;

    private String publisher;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishedDate;

    private List<String> imageUrls = new ArrayList<>();

    @NotNull(message = "Category is required")
    private Long categoryId;

    private String categoryName;

    private boolean active;

    public static BookDTO fromEntity(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .originalPrice(book.getOriginalPrice())
                .salePrice(book.getSalePrice())
                .stockQuantity(book.getStockQuantity())
                .soldQuantity(book.getSoldQuantity())
                .publisher(book.getPublisher())
                .publishedDate(book.getPublishedDate())
                .imageUrls(book.getImageUrls() != null ? book.getImageUrls() : new ArrayList<>())
                .categoryId(book.getCategory() != null ? book.getCategory().getId() : null)
                .categoryName(book.getCategory() != null ? book.getCategory().getName() : null)
                .active(book.isActive())
                .build();
    }

    public Book toEntity() {
        Book book = new Book();

        book.setId(this.id);
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setDescription(this.description);
        book.setOriginalPrice(this.originalPrice);
        book.setSalePrice(this.salePrice);
        book.setStockQuantity(this.stockQuantity);
        book.setSoldQuantity(this.soldQuantity != null ? this.soldQuantity : 0);
        book.setPublisher(this.publisher);
        book.setPublishedDate(this.publishedDate);
        book.setImageUrls(this.imageUrls);
        book.setActive(this.active);

        return book;
    }
}
