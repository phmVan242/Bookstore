package com.example.Bookstore.dto;

import com.example.Bookstore.model.enums.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Long userId;
    private OrderStatus status;
    private String shipment;
    private String note;
    private LocalDateTime orderDate;
    private String paymentMethod;
}
