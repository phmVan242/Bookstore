package com.example.Bookstore.controller;

import com.example.Bookstore.dto.PromotionDTO;
import com.example.Bookstore.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    private final PromotionService promotionService;

    // Lấy tất cả promotions
    @GetMapping
    public ResponseEntity<List<PromotionDTO>> getAllPromotions() {
        List<PromotionDTO> promotions = promotionService.getAllPromotions();
        return ResponseEntity.ok(promotions);
    }

    // Lấy promotion theo ID
    @GetMapping("/{id}")
    public ResponseEntity<PromotionDTO> getPromotionById(@PathVariable Long id) {
        PromotionDTO promotion = promotionService.getPromotionById(id);
        return ResponseEntity.ok(promotion);
    }

    // Tạo mới promotion
    @PostMapping
    public ResponseEntity<PromotionDTO> createPromotion(@RequestBody PromotionDTO promotionDto) {
        PromotionDTO savedPromotion = promotionService.createPromotion(promotionDto);
        return new ResponseEntity<>(savedPromotion, HttpStatus.CREATED);
    }

    // Cập nhật promotion
    @PutMapping("/{id}")
    public ResponseEntity<PromotionDTO> updatePromotion(@PathVariable Long id, @RequestBody PromotionDTO promotionDto) {
        PromotionDTO updated = promotionService.updatePromotion(id, promotionDto);
        return ResponseEntity.ok(updated);
    }

    // Xóa promotion
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deletePromotion(@PathVariable Long id) {
//        promotionService.deletePromotion(id);
//        return ResponseEntity.ok("Promotion deleted successfully!");
//    }
}
