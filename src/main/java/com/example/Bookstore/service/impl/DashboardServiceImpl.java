package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.DashboardDTO;
import com.example.Bookstore.dto.MonthlySalesDTO;
import com.example.Bookstore.model.enums.OrderStatus;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.repository.OrderRepository;
import com.example.Bookstore.repository.UserRepository;
import com.example.Bookstore.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashBoardService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    @Override
    public DashboardDTO getMetrics() {

        // ===== COUNT =====
        long totalUsers = userRepository.count();
        long totalOrders = orderRepository.count();
        long totalBooks = bookRepository.count();

        // ===== REVENUE TODAY =====
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(23, 59, 59);

        Double revenueToday = orderRepository.sumRevenueByDateRange(
                OrderStatus.DELIVERED,
                startOfDay,
                endOfDay
        );

        if (revenueToday == null) {
            revenueToday = 0.0;
        }

        // ===== REVENUE BY MONTH =====
        List<MonthlySalesDTO> monthlySales = calculateMonthlySales();

        return new DashboardDTO(
                totalUsers,
                totalOrders,
                totalBooks,
                revenueToday,
                monthlySales
        );
    }

    private List<MonthlySalesDTO> calculateMonthlySales() {
        List<MonthlySalesDTO> monthlySales = new ArrayList<>();

        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        int currentYear = LocalDate.now().getYear();

        for (int i = 0; i < 12; i++) {
            int month = i + 1;

            LocalDateTime startOfMonth = LocalDateTime.of(currentYear, month, 1, 0, 0, 0);
            LocalDateTime endOfMonth = LocalDateTime.of(
                    currentYear, month,
                    YearMonth.of(currentYear, month).lengthOfMonth(),
                    23, 59, 59
            );

            Double sales = orderRepository.sumRevenueByDateRange(
                    OrderStatus.PENDING,
                    startOfMonth,
                    endOfMonth
            );

            monthlySales.add(new MonthlySalesDTO(monthNames[i], sales != null ? sales : 0.0));
        }

        return monthlySales;
    }
}