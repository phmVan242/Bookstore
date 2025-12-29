package com.example.Bookstore.dto;

import com.example.Bookstore.model.Promotion;
import com.example.Bookstore.model.enums.PromotionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionDTO {

    private Long id;

    @NotBlank(message = "Promotion name is required")
    @Size(min = 2, max = 100, message = "Promotion name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Promotion code is required")
    @Size(min = 2, max = 20, message = "Promotion code must be between 2 and 20 characters")
    private String code;

    @NotNull(message = "Promotion type is required")
    private PromotionType type;

    @NotNull(message = "Promotion value is required")
    @Min(value = 0, message = "Promotion value cannot be negative")
    private Double value;

    @NotNull(message = "Start date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private String description;

    private Boolean active;

    private boolean current;
}
