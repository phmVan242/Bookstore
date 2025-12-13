package com.example.Bookstore.dto;

import com.example.Bookstore.model.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Book title is required")
    @Size(min = 2, max = 255, message = "Book title must be between 2 and 255 characters")
    private String title;

    private String author;

    private String description;

    @NotNull(message = "Original price is required")
    @Min(value = 0, message = "Original price cannot be negative")
    private Double originalPrice;

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

}
