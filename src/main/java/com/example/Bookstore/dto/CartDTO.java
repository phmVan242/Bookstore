package com.example.Bookstore.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    private Long id;

    private Long userId;

    private String username;

    private List<CartItemDTO> items = new ArrayList<>();

    private Double totalAmount;
}
