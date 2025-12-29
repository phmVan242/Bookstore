package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.PromotionDTO;
import com.example.Bookstore.exception.ResourceNotFoundException;
import com.example.Bookstore.mapper.PromotionMapper;
import com.example.Bookstore.model.Promotion;
import com.example.Bookstore.repository.PromotionRepository;
import com.example.Bookstore.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PromotionServiceImpl  implements PromotionService {

    private final PromotionRepository promotionRepository;

    @Override
    public List<PromotionDTO> getAllPromotions() {
        return promotionRepository.findAll()
                .stream()
                .map(PromotionMapper::mapToPromotionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PromotionDTO getPromotionById(Long id) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Promotion not found with id: " + id));
        return PromotionMapper.mapToPromotionDTO(promotion);
    }

    @Override
    public PromotionDTO createPromotion(PromotionDTO dto) {
        validateDateRange(dto.getStartDate(), dto.getEndDate());

        Promotion promotion = PromotionMapper.mapToPromotion(dto);
        promotion.setIsActive(true);

        return PromotionMapper.mapToPromotionDTO(
                promotionRepository.save(promotion)
        );
    }

    @Override
    public PromotionDTO updatePromotion(Long id, PromotionDTO dto) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Promotion not found with id: " + id));

        validateDateRange(dto.getStartDate(), dto.getEndDate());

        promotion.setName(dto.getName());
        promotion.setCode(dto.getCode());
        promotion.setType(dto.getType());
        promotion.setValue(dto.getValue());
        promotion.setStartDate(dto.getStartDate());
        promotion.setEndDate(dto.getEndDate());
        promotion.setDescription(dto.getDescription());
        promotion.setIsActive(dto.getActive());

        return PromotionMapper.mapToPromotionDTO(
                promotionRepository.save(promotion)
        );
    }

    @Override
    public void deactivatePromotion(Long id) {
        Promotion promotion = promotionRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Promotion not found with id: " + id));

        promotion.setIsActive(false);
        promotionRepository.save(promotion);
    }

    private void validateDateRange(LocalDate start, LocalDate end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
    }
}
