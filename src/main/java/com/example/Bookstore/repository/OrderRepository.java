package com.example.Bookstore.repository;

import com.example.Bookstore.dto.OrderDTO;
import com.example.Bookstore.model.Order;
import com.example.Bookstore.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<OrderDTO> findByUserId(Long id);


    // Lấy danh sách order theo status
    List<OrderDTO> findByStatus(OrderStatus status);

    // Lấy danh sách order theo userId và status
    List<OrderDTO> findByUserIdAndStatus(Long userId, OrderStatus status);

    // Tổng doanh thu theo status và khoảng thời gian
    @Query("SELECT COALESCE(SUM(o.finalAmount), 0) FROM Order o WHERE o.status = :status AND o.orderDate BETWEEN :start AND :end")
    Double sumRevenueByDateRange(
            @Param("status") OrderStatus status,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    // Đếm số order theo status
    long countByStatus(OrderStatus status);

    // Đếm số order theo status và khoảng thời gian
    @Query("SELECT COUNT(o) FROM Order o WHERE o.status = :status AND o.orderDate BETWEEN :start AND :end")
    long countByStatusAndDateRange(
            @Param("status") OrderStatus status,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    // Lấy tất cả order với user (JOIN FETCH để tránh N+1 query)
    @Query("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.user LEFT JOIN FETCH o.orderDetails")
    List<OrderDTO> findAllWithDetails();

    // Lấy order theo id với user và orderDetails
    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.user LEFT JOIN FETCH o.orderDetails WHERE o.id = :id")
    Order findByIdWithDetails(@Param("id") Long id);
}