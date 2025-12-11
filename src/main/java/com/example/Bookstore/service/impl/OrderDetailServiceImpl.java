package com.example.Bookstore.service.impl;

import com.example.Bookstore.model.OrderDetail;
import com.example.Bookstore.model.Order;
import com.example.Bookstore.repository.OrderDetailRepository;
import com.example.Bookstore.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail getOrderDetailById(Long id) {
        Optional<OrderDetail> optional = orderDetailRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrder(Order order) {
        return orderDetailRepository.findByOrder(order);
    }

    @Override
    public OrderDetail createOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail updateOrderDetail(Long id, OrderDetail orderDetail) {
        Optional<OrderDetail> existing = orderDetailRepository.findById(id);
        if (existing.isPresent()) {
//            OrderDetail updated = existing.get();
//            updated.setOrder(orderDetail.getOrder());
//            updated.setBook(orderDetail.getBook());
//            updated.setQuantity(orderDetail.getQuantity());
//            updated.setPrice(orderDetail.getPrice());
//            return orderDetailRepository.save(updated);
        }
        return null;
    }

    @Override
    public void deleteOrderDetail(Long id) {
        orderDetailRepository.deleteById(id);
    }
}
