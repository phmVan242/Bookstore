package com.example.Bookstore.service;

import com.example.Bookstore.dto.CartItemDto;

import java.util.List;

public interface CartItemService {
    List<CartItemDto> getItemsByCartId(Long cartId);
    CartItemDto updateItemQuantity(Long itemId, int quantity);
    void removeItem(Long itemId);
}
