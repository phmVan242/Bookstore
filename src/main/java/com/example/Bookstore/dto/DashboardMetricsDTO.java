package com.example.Bookstore.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class DashboardMetricsDTO {
    private long totalUsers;
    private long totalOrders;
    private long totalBooks;
    private Double revenueToday;
}
