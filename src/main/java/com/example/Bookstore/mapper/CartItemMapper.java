package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.CartItemDto;
import com.example.Bookstore.model.CartItem;

public class CartItemMapper {

    public static CartItemDto mapToCartItemDto(CartItem item) {
        return new CartItemDto(
                item.getId(),
                item.getBook().getId(),
                item.getBook().getTitle(),
                item.getBook().getPrice(),
                item.getQuantity()
        );
    }

    public static CartItem mapToCartItem(CartItemDto dto) {
        CartItem item = new CartItem();
        item.setId(dto.getId());
        item.setQuantity(dto.getQuantity());
        // book và cart sẽ được set ở service khi xử lý logic
        return item;
    }
}
