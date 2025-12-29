package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.PromotionDTO;
import com.example.Bookstore.model.Promotion;

public class PromotionMapper {

    public static PromotionDTO mapToPromotionDTO(Promotion promotion) {
        PromotionDTO dto = new PromotionDTO();
        dto.setId(promotion.getId());
        dto.setName(promotion.getName());
        dto.setCode(promotion.getCode());
        dto.setType(promotion.getType());
        dto.setValue(promotion.getValue());
        dto.setStartDate(promotion.getStartDate());
        dto.setEndDate(promotion.getEndDate());
        dto.setDescription(promotion.getDescription());
        dto.setActive(promotion.getIsActive());
        return dto;
    }

    public static Promotion mapToPromotion(PromotionDTO dto) {
        Promotion promotion = new Promotion();
        promotion.setName(dto.getName());
        promotion.setCode(dto.getCode());
        promotion.setType(dto.getType());
        promotion.setValue(dto.getValue());
        promotion.setStartDate(dto.getStartDate());
        promotion.setEndDate(dto.getEndDate());
        promotion.setDescription(dto.getDescription());
        promotion.setIsActive(
                promotion.getIsActive() != null ? promotion.getIsActive() : true
        );
        return promotion;
    }
}

