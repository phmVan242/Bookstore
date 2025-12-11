package com.example.Bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "promotions")
public class Promotion extends BaseModel{

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private double discountPercent;

    @Column(length = 255)
    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @ManyToMany(mappedBy = "promotions")
    @JsonIgnore
    private List<OrderDetail> orderDetails;
}
