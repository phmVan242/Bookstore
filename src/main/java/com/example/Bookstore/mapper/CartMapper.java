package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.CartDTO;
import com.example.Bookstore.model.Cart;

import java.util.stream.Collectors;

public class CartMapper {

    public static CartDTO mapToCartDTO(Cart cart) {
        CartDTO dto = new CartDTO();
        dto.setId(cart.getId());
        dto.setUserId(cart.getUser().getId());
        dto.setUsername(cart.getUser().getUsername());

        dto.setItems(
                cart.getCartItems()
                        .stream()
                        .map(CartItemMapper::mapToCartItemDTO)
                        .collect(Collectors.toList())
        );

        double total = cart.getCartItems()
                .stream()
                .mapToDouble(i -> i.getBook().getOriginalPrice() * i.getQuantity())
                .sum();

        dto.setTotalAmount(total);

        return dto;
    }
}
