package com.example.Bookstore.service;

import com.example.Bookstore.dto.OrderDTO;
import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(Long id);
    List<OrderDTO> getOrdersByUser(Long userId);
    OrderDTO createOrder(OrderDTO orderDto);
    OrderDTO updateOrderStatus(Long orderId, String status);
    void deleteOrder(Long id);
}
