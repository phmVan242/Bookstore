package com.example.Bookstore.service;

import com.example.Bookstore.dto.CartDto;

public interface CartService {
    CartDto getCartByUserId(Long userId);
    CartDto addItemToCart(Long userId, Long bookId, int quantity);
    CartDto removeItemFromCart(Long userId, Long bookId);
    void clearCart(Long userId);
}
