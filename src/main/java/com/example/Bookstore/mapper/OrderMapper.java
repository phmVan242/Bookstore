package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.OrderDto;
import com.example.Bookstore.model.Order;
import com.example.Bookstore.model.User;

public class OrderMapper {

    public static OrderDto mapToOrderDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setUserId(order.getUser() != null ? order.getUser().getId() : null);
        dto.setStatus(order.getStatus());
        dto.setShipment(order.getShipment());
        dto.setNote(order.getNote());
        dto.setOrderDate(order.getOrderDate());
        dto.setPaymentMethod(order.getPaymentMethod());
        return dto;
    }

    public static Order mapToOrder(OrderDto dto, User user) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setUser(user); // cần truyền User từ service
        order.setStatus(dto.getStatus());
        order.setShipment(dto.getShipment());
        order.setNote(dto.getNote());
        order.setOrderDate(dto.getOrderDate() != null ? dto.getOrderDate() : null);
        order.setPaymentMethod(dto.getPaymentMethod());
        return order;
    }
}
