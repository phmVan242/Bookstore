package com.example.Bookstore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDTO {

    private Long id;

    private Long orderId;

    @NotNull(message = "Book is required")
    private Long bookId;

    private String bookTitle;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @NotNull(message = "Original price is required")
    @Min(value = 0, message = "Original price cannot be negative")
    private Double originalPrice;

    private Double discountedPrice;

    private Long promotionId;

    private String promotionCode;

    private Double subtotal;
}
