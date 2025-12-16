package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.OrderDTO;
import com.example.Bookstore.exception.ResourceNotFoundException;
import com.example.Bookstore.mapper.OrderMapper;
import com.example.Bookstore.model.Order;
import com.example.Bookstore.model.User;
import com.example.Bookstore.model.enums.OrderStatus;
import com.example.Bookstore.repository.OrderRepository;
import com.example.Bookstore.repository.UserRepository;
import com.example.Bookstore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper::mapToOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found with id: " + id));
        return OrderMapper.mapToOrderDTO(order);
    }

    @Override
    public List<OrderDTO> getOrdersByUser(Long id) {
        return orderRepository.findByUserId(id);
//                .stream()
//                .map(OrderMapper::mapToOrderDTO)
//                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO createOrder(OrderDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + dto.getUserId()));

        Order order = OrderMapper.mapToOrder(dto);
        order.setUser(user);
        order.setStatus(OrderStatus.PENDING);

        return OrderMapper.mapToOrderDTO(orderRepository.save(order));
    }

    @Override
    public OrderDTO updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found with id: " + orderId));

        order.setStatus(OrderStatus.valueOf(status));
        return OrderMapper.mapToOrderDTO(orderRepository.save(order));
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order not found with id: " + id));
        orderRepository.delete(order);
    }
}
