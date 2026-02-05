package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.DashboardMetricsDTO;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.repository.OrderRepository;
import com.example.Bookstore.repository.UserRepository;
import com.example.Bookstore.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashBoardService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    @Override
    public DashboardMetricsDTO getMetrics() {
        long users = userRepository.count();
        long orders = orderRepository.count();
        long books = bookRepository.count();
//        Double revenueDay  orderRepository

        return new DashboardMetricsDTO(
                users,
                orders,
                books,
                0.0
        );
    }
}
