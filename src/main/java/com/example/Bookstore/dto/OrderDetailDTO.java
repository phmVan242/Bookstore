package com.example.Bookstore.dto;

import com.example.Bookstore.model.OrderDetail;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDTO {

    private Long id;

    private Long orderId;

    private Long bookId;
    private String bookTitle;

    private Integer quantity;

    private Double originalPrice;

    private Double discountedPrice;

    private Double finalPrice;

    private Long promotionId;
    private String promotionName;

    public static OrderDetailDTO fromEntity(OrderDetail orderDetail) {
        if (orderDetail == null) return null;

        return OrderDetailDTO.builder()
                .id(orderDetail.getId())
                .orderId(orderDetail.getOrder() != null ? orderDetail.getOrder().getId() : null)
                .bookId(orderDetail.getBook() != null ? orderDetail.getBook().getId() : null)
                .bookTitle(orderDetail.getBook() != null ? orderDetail.getBook().getTitle() : null)
                .quantity(orderDetail.getQuantity())
                .originalPrice(orderDetail.getOriginalPrice())
                .discountedPrice(orderDetail.getDiscountedPrice())
                .finalPrice(orderDetail.getFinalPrice())
                .promotionId(orderDetail.getPromotion() != null ? orderDetail.getPromotion().getId() : null)
                .promotionName(orderDetail.getPromotion() != null ? orderDetail.getPromotion().getName() : null)
                .build();
    }

    public OrderDetail toEntity() {
        OrderDetail detail = new OrderDetail();

        detail.setId(this.id);
        detail.setQuantity(this.quantity);
        detail.setOriginalPrice(this.originalPrice);
        detail.setDiscountedPrice(this.discountedPrice);
        detail.setFinalPrice(this.finalPrice);

        return detail;
    }
}
