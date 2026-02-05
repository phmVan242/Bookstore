package com.example.Bookstore.controller;

import com.example.Bookstore.dto.DashboardMetricsDTO;
import com.example.Bookstore.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashBoardService dashBoardService;

    @GetMapping 
    public DashboardMetricsDTO getMetrics(){
        return dashBoardService.getMetrics();
    }
}
