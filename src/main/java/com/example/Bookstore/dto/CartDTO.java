package com.example.Bookstore.dto;

import com.example.Bookstore.model.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long id;
    private Long userId;
    private List<CartItemDTO> items = new ArrayList<>();

    public static CartDTO fromEntity(Cart cart) {
        if (cart == null) return null;

        CartDTO dto = new CartDTO();
        dto.setId(cart.getId());
        dto.setUserId(cart.getUser().getId());

        dto.setItems(
                cart.getCartItems().stream()
                        .map(CartItemDTO::fromEntity)
                        .toList()
        );

        return dto;
    }

    public Cart toEntity(User user, List<Book> books) {
        Cart cart = new Cart();
        cart.setId(this.id);
        cart.setUser(user);

        List<CartItem> entityItems = new ArrayList<>();

        for (CartItemDTO itemDTO : items) {
            Book book = books.stream()
                    .filter(b -> b.getId().equals(itemDTO.getBookId()))
                    .findFirst()
                    .orElseThrow();

            CartItem item = itemDTO.toEntity(book);
            item.setCart(cart);

            entityItems.add(item);
        }

        cart.setCartItems(entityItems);

        return cart;
    }
}
