package com.example.Bookstore.service;

import com.example.Bookstore.dto.PromotionDTO;

import java.util.List;

public interface PromotionService {
    List<PromotionDTO> getAllPromotions();
    PromotionDTO getPromotionById(Long id);
    PromotionDTO createPromotion(PromotionDTO promotionDto);
    PromotionDTO updatePromotion(Long id, PromotionDTO promotionDto);
    void deactivatePromotion(Long id);
}
