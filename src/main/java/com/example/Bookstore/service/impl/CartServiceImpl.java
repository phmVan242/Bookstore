package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.CartDTO;
import com.example.Bookstore.exception.ResourceNotFoundException;
import com.example.Bookstore.mapper.CartMapper;
import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.Cart;
import com.example.Bookstore.model.CartItem;
import com.example.Bookstore.model.User;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.repository.CartRepository;
import com.example.Bookstore.repository.CartItemRepository;
import com.example.Bookstore.repository.UserRepository;
import com.example.Bookstore.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    public CartDTO getCartByUserId(Long userId) {
        Cart cart = getOrCreateCart(userId);
        return CartMapper.mapToCartDTO(cart);
    }

    @Override
    public CartDTO addItemToCart(Long userId, Long bookId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        Cart cart = getOrCreateCart(userId);
        Book book = getBook(bookId);

        CartItem item = cart.getCartItems()
                .stream()
                .filter(ci -> ci.getBook().getId().equals(bookId))
                .findFirst()
                .orElse(null);

        if (item != null) {
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            item = new CartItem();
            item.setBook(book);
            item.setQuantity(quantity);
            cart.addItem(item);
        }

        cartRepository.save(cart);
        return CartMapper.mapToCartDTO(cart);
    }

    @Override
    public CartDTO updateCartItem(Long userId, Long bookId, int quantity) {
        Cart cart = getOrCreateCart(userId);

        CartItem item = cart.getCartItems()
                .stream()
                .filter(ci -> ci.getBook().getId().equals(bookId))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found in cart"));

        if (quantity <= 0) {
            cart.removeItem(item);
        } else {
            item.setQuantity(quantity);
        }

        cartRepository.save(cart);
        return CartMapper.mapToCartDTO(cart);
    }

    @Override
    public CartDTO removeItemFromCart(Long userId, Long bookId) {
        Cart cart = getOrCreateCart(userId);

        CartItem item = cart.getCartItems()
                .stream()
                .filter(ci -> ci.getBook().getId().equals(bookId))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found in cart"));

        cart.removeItem(item);
        cartRepository.save(cart);

        return CartMapper.mapToCartDTO(cart);
    }

    @Override
    public void clearCart(Long userId) {
        Cart cart = getOrCreateCart(userId);
        cart.getCartItems().clear();
        cartRepository.save(cart);
    }

    // ===================== PRIVATE METHODS =====================

    private Cart getOrCreateCart(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    User user = userRepository.findById(userId)
                            .orElseThrow(() ->
                                    new ResourceNotFoundException("User not found"));

                    Cart cart = new Cart(user);
                    return cartRepository.save(cart);
                });
    }

    private Book getBook(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found"));
    }
}
