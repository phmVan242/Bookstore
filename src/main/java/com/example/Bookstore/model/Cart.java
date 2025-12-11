package com.example.Bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carts")
public class Cart extends BaseModel {

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CartItem> cartItems = new ArrayList<>();

    public Cart(User user) {
        this.user = user;
    }

    // add / remove helpers
    public void addItem(CartItem item) {
        if (item == null) return;
        cartItems.add(item);
        item.setCart(this);
    }

    public void removeItem(CartItem item) {
        if (item == null) return;
        cartItems.remove(item);
        item.setCart(null);
    }
}
