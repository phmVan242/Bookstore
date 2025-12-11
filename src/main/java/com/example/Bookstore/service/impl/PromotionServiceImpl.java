package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.PromotionDto;
import com.example.Bookstore.mapper.PromotionMapper;
import com.example.Bookstore.model.Promotion;
import com.example.Bookstore.repository.PromotionRepository;
import com.example.Bookstore.service.PromotionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;

    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public List<PromotionDto> getAllPromotions() {
        return promotionRepository.findAll()
                .stream()
                .map(PromotionMapper::mapToPromotionDto)
                .collect(Collectors.toList());
    }

    @Override
    public PromotionDto getPromotionById(Long id) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promotion not found with id: " + id));
        return PromotionMapper.mapToPromotionDto(promotion);
    }

    @Override
    public PromotionDto createPromotion(PromotionDto promotionDto) {
        Promotion promotion = PromotionMapper.mapToPromotion(promotionDto);
        Promotion saved = promotionRepository.save(promotion);
        return PromotionMapper.mapToPromotionDto(saved);
    }

    @Override
    public PromotionDto updatePromotion(Long id, PromotionDto promotionDto) {
        Promotion existing = promotionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promotion not found with id: " + id));

        existing.setName(promotionDto.getName());
        existing.setDiscountPercent(promotionDto.getDiscountPercent());
        existing.setDescription(promotionDto.getDescription());
        existing.setStartDate(promotionDto.getStartDate());
        existing.setEndDate(promotionDto.getEndDate());

        return PromotionMapper.mapToPromotionDto(promotionRepository.save(existing));
    }

    @Override
    public void deletePromotion(Long id) {
        if (!promotionRepository.existsById(id)) {
            throw new RuntimeException("Promotion not found with id: " + id);
        }
        promotionRepository.deleteById(id);
    }
}
