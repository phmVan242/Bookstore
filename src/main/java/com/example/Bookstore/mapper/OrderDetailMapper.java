package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.OrderDetailDTO;
import com.example.Bookstore.model.OrderDetail;

public class OrderDetailMapper {

    public static OrderDetailDTO mapToOrderDetailDTO(OrderDetail detail) {
        if (detail == null) return null;

        OrderDetailDTO dto = new OrderDetailDTO();
        dto.setId(detail.getId());
        dto.setQuantity(detail.getQuantity());
        dto.setOriginalPrice(detail.getOriginalPrice());
        dto.setDiscountedPrice(detail.getDiscountedPrice());
        dto.setSubtotal(detail.getSubtotal());

        // order
        if (detail.getOrder() != null) {
            dto.setOrderId(detail.getOrder().getId());
        }

        // book
        if (detail.getBook() != null) {
            dto.setBookId(detail.getBook().getId());
            dto.setBookTitle(detail.getBook().getTitle());
        }

        // promotion
        if (detail.getPromotion() != null) {
            dto.setPromotionId(detail.getPromotion().getId());
            dto.setPromotionCode(detail.getPromotion().getCode());
        }

        return dto;
    }

    public static OrderDetail mapToOrderDetail(OrderDetailDTO dto) {
        if (dto == null) return null;

        OrderDetail detail = new OrderDetail();
        detail.setId(dto.getId());
        detail.setQuantity(dto.getQuantity());
        detail.setOriginalPrice(dto.getOriginalPrice());
        detail.setDiscountedPrice(dto.getDiscountedPrice());

        return detail;
    }
}
