package com.example.Bookstore.dto;

import com.example.Bookstore.model.Order;
import com.example.Bookstore.model.OrderDetail;
import com.example.Bookstore.model.enums.OrderStatus;
import com.example.Bookstore.model.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private Long id;

    @NotNull(message = "User is required")
    private Long userId;

    private String username;

    private Double totalAmount;

    private Double discountAmount;

    private Double finalAmount;

    @NotNull(message = "Order status is required")
    private OrderStatus status;

    private String shippingAddress;

    @NotNull(message = "Payment method is required")
    private PaymentMethod paymentMethod;

    private String note;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime completedDate;

    private List<OrderDetailDTO> orderDetails = new ArrayList<>();
}
