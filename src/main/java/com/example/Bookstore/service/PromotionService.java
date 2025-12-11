package com.example.Bookstore.service;

import com.example.Bookstore.dto.PromotionDto;

import java.util.List;

public interface PromotionService {
    List<PromotionDto> getAllPromotions();
    PromotionDto getPromotionById(Long id);
    PromotionDto createPromotion(PromotionDto promotionDto);
    PromotionDto updatePromotion(Long id, PromotionDto promotionDto);
    void deletePromotion(Long id);
}
