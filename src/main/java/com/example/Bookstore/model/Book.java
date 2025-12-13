package com.example.Bookstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book extends BaseModel{

    @Column(nullable = false)
    private String title;

    private String author;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "original_price", nullable = false)
    private Double originalPrice;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @Column(name = "sold_quantity")
    private Integer soldQuantity = 0;

    private String publisher;

    @Column(name = "published_date")
    private LocalDate publishedDate;

    @Transient
    private List<String> imageUrls = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "is_active")
    private boolean isActive = true;

    @OneToMany(mappedBy = "book")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<CartItem> cartItems = new ArrayList<>();
}
