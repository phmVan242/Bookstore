package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.PromotionDto;
import com.example.Bookstore.model.Promotion;

public class PromotionMapper {

    public static PromotionDto mapToPromotionDto(Promotion promotion) {
        return new PromotionDto(
                promotion.getId(),
                promotion.getName(),
                promotion.getDiscountPercent(),
                promotion.getDescription(),
                promotion.getStartDate(),
                promotion.getEndDate()
        );
    }

    public static Promotion mapToPromotion(PromotionDto dto) {
        Promotion promotion = new Promotion();
        promotion.setId(dto.getId());
        promotion.setName(dto.getName());
        promotion.setDiscountPercent(dto.getDiscountPercent());
        promotion.setDescription(dto.getDescription());
        promotion.setStartDate(dto.getStartDate());
        promotion.setEndDate(dto.getEndDate());
        return promotion;
    }
}
