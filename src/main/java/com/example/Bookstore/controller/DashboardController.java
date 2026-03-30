package com.example.Bookstore.controller;

import com.example.Bookstore.dto.DashboardDTO;
import com.example.Bookstore.service.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashBoardService dashBoardService;

    @GetMapping
    public DashboardDTO getMetrics(){
        return dashBoardService.getMetrics();
    }

    @GetMapping("/test")
    public ResponseEntity<Integer> a(){
//        System.out.println("WTF!!!");
        return ResponseEntity.ok(100);
    }
}
