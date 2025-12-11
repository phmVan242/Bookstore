package com.example.Bookstore.controller;

import com.example.Bookstore.dto.CartDto;
import com.example.Bookstore.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    // ✅ Lấy giỏ hàng của user
    @GetMapping("/{userId}")
    public ResponseEntity<CartDto> getCartByUserId(@PathVariable Long userId) {
        CartDto cartDto = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cartDto);
    }

    // ✅ Thêm sản phẩm vào giỏ
    @PostMapping("/{userId}/add/{bookId}")
    public ResponseEntity<CartDto> addItemToCart(
            @PathVariable Long userId,
            @PathVariable Long bookId,
            @RequestParam(defaultValue = "1") int quantity) {

        CartDto cartDto = cartService.addItemToCart(userId, bookId, quantity);
        return new ResponseEntity<>(cartDto, HttpStatus.CREATED);
    }

    // ✅ Xóa 1 sản phẩm khỏi giỏ
    @DeleteMapping("/{userId}/remove/{bookId}")
    public ResponseEntity<CartDto> removeItemFromCart(
            @PathVariable Long userId,
            @PathVariable Long bookId) {

        CartDto cartDto = cartService.removeItemFromCart(userId, bookId);
        return ResponseEntity.ok(cartDto);
    }

    // ✅ Xóa toàn bộ giỏ hàng
    @DeleteMapping("/{userId}/clear")
    public ResponseEntity<String> clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok("Cart cleared successfully!");
    }
}
