package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.CartItemDTO;
import com.example.Bookstore.model.CartItem;

public class CartItemMapper {

    public static CartItemDTO mapToDTO(CartItem item) {
        CartItemDTO dto = new CartItemDTO();
        dto.setId(item.getId());
        dto.setBookId(item.getBook().getId());
        dto.setBookTitle(item.getBook().getTitle());
        dto.setBookPrice(item.getBook().getOriginalPrice());
        dto.setQuantity(item.getQuantity());
        dto.setSubtotal(item.getBook().getOriginalPrice() * item.getQuantity());
        return dto;
    }
}
