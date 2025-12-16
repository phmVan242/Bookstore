package com.example.Bookstore.service;

import com.example.Bookstore.dto.CartDTO;

public interface CartService {

    CartDTO getCartByUserId(Long userId);

    CartDTO addItemToCart(Long userId, Long bookId, int quantity);

    CartDTO updateCartItem(Long userId, Long bookId, int quantity);

    CartDTO removeItemFromCart(Long userId, Long bookId);

    void clearCart(Long userId);
}

