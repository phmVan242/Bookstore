package com.example.Bookstore.service;

import com.example.Bookstore.dto.CartItemDTO;

import java.util.List;

public interface CartItemService {
    List<CartItemDTO> getItemsByCartId(Long cartId);
    CartItemDTO updateItemQuantity(Long itemId, int quantity);
    void removeItem(Long itemId);
}
