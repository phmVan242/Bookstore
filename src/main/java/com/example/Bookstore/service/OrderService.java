package com.example.Bookstore.service;

import com.example.Bookstore.dto.OrderDto;
import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();
    OrderDto getOrderById(Long id);
    List<OrderDto> getOrdersByUser(Long userId);
    OrderDto createOrder(OrderDto orderDto);
    OrderDto updateOrder(Long id, OrderDto orderDto);
    void deleteOrder(Long id);
}
