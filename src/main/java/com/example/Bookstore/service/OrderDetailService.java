package com.example.Bookstore.service;

import com.example.Bookstore.model.OrderDetail;
import com.example.Bookstore.model.Order;
import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> getAllOrderDetails();
    OrderDetail getOrderDetailById(Long id);
    List<OrderDetail> getOrderDetailsByOrder(Long id);
    OrderDetail createOrderDetail(OrderDetail orderDetail);
    OrderDetail updateOrderDetail(Long id, OrderDetail orderDetail);
    void deleteOrderDetail(Long id);
}
