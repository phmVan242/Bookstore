package com.example.Bookstore.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/section")
public class SectionController {

    @GetMapping("/hello")
    public String hello() {
        return "Bạn đã truy cập vào section bảo mật thành công!";
    }
}

