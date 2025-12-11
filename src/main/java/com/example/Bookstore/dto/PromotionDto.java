package com.example.Bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionDto {
    private Long id;
    private String name;
    private double discountPercent;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
