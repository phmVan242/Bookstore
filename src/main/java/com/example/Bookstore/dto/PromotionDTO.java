package com.example.Bookstore.dto;

import com.example.Bookstore.model.Promotion;
import com.example.Bookstore.model.enums.PromotionType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromotionDTO {

    private Long id;

    private String name;

    private String code;

    private PromotionType type;

    private Double value;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    private boolean isActive;

    public static PromotionDTO fromEntity(Promotion promotion) {
        if (promotion == null) return null;

        return PromotionDTO.builder()
                .id(promotion.getId())
                .name(promotion.getName())
                .code(promotion.getCode())
                .type(promotion.getType())
                .value(promotion.getValue())
                .startDate(promotion.getStartDate())
                .endDate(promotion.getEndDate())
                .description(promotion.getDescription())
                .isActive(promotion.isActive())
                .build();
    }

    public Promotion toEntity() {
        Promotion promotion = new Promotion();

        promotion.setId(this.id);
        promotion.setName(this.name);
        promotion.setCode(this.code);
        promotion.setType(this.type);
        promotion.setValue(this.value);
        promotion.setStartDate(this.startDate);
        promotion.setEndDate(this.endDate);
        promotion.setDescription(this.description);
        promotion.setActive(this.isActive);

        return promotion;
    }
}
