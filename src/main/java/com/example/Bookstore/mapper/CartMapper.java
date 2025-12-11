package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.CartDTO;
import com.example.Bookstore.dto.CartItemDTO;
import com.example.Bookstore.model.Cart;
import com.example.Bookstore.model.CartItem;
import com.example.Bookstore.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {

    public static CartDTO mapToCartDto(Cart cart) {
        List<CartItemDTO> itemDtos = cart.getCartItems().stream().map(item ->
                new CartItemDTO(
                        item.getId(),
                        item.getBook().getId(),
                        item.getBook().getTitle(),
                        item.getBook().getPrice(),
                        item.getQuantity()
                )).collect(Collectors.toList());

        return new CartDTO(
                cart.getId(),
                cart.getUser().getId(),
                itemDtos
        );
    }

    public static Cart mapToCart(CartDTO dto, User user, List<CartItem> items) {
        Cart cart = new Cart();
        cart.setId(dto.getId());
        cart.setUser(user);
        cart.setCartItems(items);
        return cart;
    }
}
