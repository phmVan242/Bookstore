package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.CartItemDTO;
import com.example.Bookstore.mapper.CartItemMapper;
import com.example.Bookstore.model.Cart;
import com.example.Bookstore.model.CartItem;
import com.example.Bookstore.repository.CartItemRepository;
import com.example.Bookstore.repository.CartRepository;
import com.example.Bookstore.service.CartItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository, CartRepository cartRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public List<CartItemDTO> getItemsByCartId(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        return cartItemRepository.findByCart(cart)
                .stream()
                .map(CartItemMapper::mapToCartItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public CartItemDTO updateItemQuantity(Long itemId, int quantity) {
        CartItem item = cartItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        item.setQuantity(quantity);
        cartItemRepository.save(item);
        return CartItemMapper.mapToCartItemDto(item);
    }

    @Override
    public void removeItem(Long itemId) {
        if (!cartItemRepository.existsById(itemId)) {
            throw new RuntimeException("Cart item not found");
        }
        cartItemRepository.deleteById(itemId);
    }
}
