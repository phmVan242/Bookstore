package com.example.Bookstore.dto;

import com.example.Bookstore.model.Category;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private double price;
    private int stock;
    private String description;
    private String image;
    private Set<Category> categories;
//    private LocalDateTime createdAt ;
//    private LocalDateTime updatedAt;


}
