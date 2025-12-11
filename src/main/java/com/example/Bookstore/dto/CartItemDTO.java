package com.example.Bookstore.dto;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.CartItem;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Long id;
    private Long bookId;
    private String bookTitle;
    private int quantity;

    public static CartItemDTO fromEntity(CartItem item) {
        if (item == null) return null;

        CartItemDTO dto = new CartItemDTO();
        dto.setId(item.getId());
        dto.setBookId(item.getBook().getId());
        dto.setBookTitle(item.getBook().getTitle());
        dto.setQuantity(item.getQuantity());
        return dto;
    }

    public CartItem toEntity(Book book) {
        CartItem item = new CartItem();
        item.setId(this.id);
        item.setBook(book);
        item.setQuantity(this.quantity);
        return item;
    }
}
