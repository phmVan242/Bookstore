package com.example.Bookstore.controller;

import com.example.Bookstore.dto.CartItemDTO;
import com.example.Bookstore.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    private final CartItemService cartItemService;

    @GetMapping("/{cartId}")
    public ResponseEntity<List<CartItemDTO>> getItemsByCart(@PathVariable Long cartId) {
        List<CartItemDTO> items = cartItemService.getItemsByCartId(cartId);
        return ResponseEntity.ok(items);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<CartItemDTO> updateQuantity(
            @PathVariable Long itemId,
            @RequestParam int quantity) {

        CartItemDTO updated = cartItemService.updateItemQuantity(itemId, quantity);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> removeItem(@PathVariable Long itemId) {
        cartItemService.removeItem(itemId);
        return ResponseEntity.ok("Cart item removed successfully!");
    }
}
