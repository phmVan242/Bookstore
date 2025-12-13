package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.OrderDTO;
import com.example.Bookstore.model.Order;

import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDTO mapToOrderDTO(Order order) {
        if (order == null) return null;

        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setDiscountAmount(order.getDiscountAmount());
        dto.setFinalAmount(order.getFinalAmount());
        dto.setStatus(order.getStatus());
        dto.setShippingAddress(order.getShippingAddress());
        dto.setPaymentMethod(order.getPaymentMethod());
        dto.setNote(order.getNote());
        dto.setOrderDate(order.getOrderDate());
        dto.setCompletedDate(order.getCompletedDate());

        // user
        if (order.getUser() != null) {
            dto.setUserId(order.getUser().getId());
            dto.setUsername(order.getUser().getUsername());
        }

        // order details
        if (order.getOrderDetails() != null) {
            dto.setOrderDetails(
                    order.getOrderDetails().stream()
                            .map(OrderDetailMapper::mapToOrderDetailDTO)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    public static Order mapToOrder(OrderDTO dto) {
        if (dto == null) return null;

        Order order = new Order();
        order.setId(dto.getId());
        order.setTotalAmount(dto.getTotalAmount());
        order.setDiscountAmount(dto.getDiscountAmount());
        order.setFinalAmount(dto.getFinalAmount());
        order.setStatus(dto.getStatus());
        order.setShippingAddress(dto.getShippingAddress());
        order.setPaymentMethod(dto.getPaymentMethod());
        order.setNote(dto.getNote());
        order.setOrderDate(dto.getOrderDate());
        order.setCompletedDate(dto.getCompletedDate());
        // ❗ user + orderDetails set trong Service

        return order;
    }
}
