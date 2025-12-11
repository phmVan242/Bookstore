package com.example.Bookstore.dto;

import com.example.Bookstore.model.Order;
import com.example.Bookstore.model.OrderDetail;
import com.example.Bookstore.model.enums.OrderStatus;
import com.example.Bookstore.model.enums.PaymentMethod;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private Long id;

    private Long userId;
    private String userName;

    private Double totalAmount;

    private Double discountAmount;

    private Double finalAmount;

    private OrderStatus status;

    private String shippingAddress;

    private PaymentMethod paymentMethod;

    private String note;

    private LocalDateTime orderDate;

    private LocalDateTime completedDate;

    private List<Long> orderDetailIds;

    public static OrderDTO fromEntity(Order order) {
        if (order == null) return null;

        return OrderDTO.builder()
                .id(order.getId())
                .userId(order.getUser() != null ? order.getUser().getId() : null)
                .userName(order.getUser() != null ? order.getUser().getFullName() : null)
                .totalAmount(order.getTotalAmount())
                .discountAmount(order.getDiscountAmount())
                .finalAmount(order.getFinalAmount())
                .status(order.getStatus())
                .shippingAddress(order.getShippingAddress())
                .paymentMethod(order.getPaymentMethod())
                .note(order.getNote())
                .orderDate(order.getOrderDate())
                .completedDate(order.getCompletedDate())
                .orderDetailIds(order.getOrderDetails().stream()
                        .map(OrderDetail::getId)
                        .toList())
                .build();
    }

    public Order toEntity() {
        Order order = new Order();

        order.setId(this.id);
        order.setTotalAmount(this.totalAmount);
        order.setDiscountAmount(this.discountAmount);
        order.setFinalAmount(this.finalAmount);
        order.setStatus(this.status != null ? this.status : OrderStatus.PENDING);
        order.setShippingAddress(this.shippingAddress);
        order.setPaymentMethod(this.paymentMethod);
        order.setNote(this.note);
        order.setOrderDate(this.orderDate != null ? this.orderDate : LocalDateTime.now());
        order.setCompletedDate(this.completedDate);

        return order;
    }
}
