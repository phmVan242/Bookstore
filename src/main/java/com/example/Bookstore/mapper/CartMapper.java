package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.CartDto;
import com.example.Bookstore.dto.CartItemDto;
import com.example.Bookstore.model.Cart;
import com.example.Bookstore.model.CartItem;
import com.example.Bookstore.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {

    public static CartDto mapToCartDto(Cart cart) {
        List<CartItemDto> itemDtos = cart.getCartItems().stream().map(item ->
                new CartItemDto(
                        item.getId(),
                        item.getBook().getId(),
                        item.getBook().getTitle(),
                        item.getBook().getPrice(),
                        item.getQuantity()
                )).collect(Collectors.toList());

        return new CartDto(
                cart.getId(),
                cart.getUser().getId(),
                itemDtos
        );
    }

    public static Cart mapToCart(CartDto dto, User user, List<CartItem> items) {
        Cart cart = new Cart();
        cart.setId(dto.getId());
        cart.setUser(user);
        cart.setCartItems(items);
        return cart;
    }
}
