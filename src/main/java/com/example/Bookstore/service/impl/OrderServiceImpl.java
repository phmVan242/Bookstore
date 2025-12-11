package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.OrderDto;
import com.example.Bookstore.mapper.OrderMapper;
import com.example.Bookstore.model.Order;
import com.example.Bookstore.model.User;
import com.example.Bookstore.repository.OrderRepository;
import com.example.Bookstore.repository.UserRepository;
import com.example.Bookstore.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDto> getOrdersByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return orderRepository.findByUser(user)
                .stream()
                .map(OrderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        User user = userRepository.findById(orderDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + orderDto.getUserId()));

        Order order = OrderMapper.mapToOrder(orderDto, user);
        Order savedOrder = orderRepository.save(order);

        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));

        // cập nhật các trường có thể thay đổi
        existingOrder.setStatus(orderDto.getStatus());
        existingOrder.setShipment(orderDto.getShipment());
        existingOrder.setNote(orderDto.getNote());
        existingOrder.setPaymentMethod(orderDto.getPaymentMethod());
        existingOrder.setOrderDate(orderDto.getOrderDate());

        Order updatedOrder = orderRepository.save(existingOrder);
        return OrderMapper.mapToOrderDto(updatedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }
}
