package com.example.Bookstore.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class DashboardDTO {
    private long totalUsers;
    private long totalOrders;
    private long totalBooks;
    private Double revenueToday;
    private List<MonthlySalesDTO> monthlySales;
}
