package com.example.Bookstore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {

    private Long id;

    @NotNull(message = "Book is required")
    private Long bookId;

    private String bookTitle;

    private Double bookPrice;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    private Double subtotal;
}
