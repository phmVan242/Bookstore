package com.example.Bookstore.repository;

import com.example.Bookstore.model.OrderDetail;
import com.example.Bookstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrder(Order order);
}
