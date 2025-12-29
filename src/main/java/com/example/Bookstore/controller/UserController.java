package com.example.Bookstore.controller;

import com.example.Bookstore.dto.UserDTO;
import com.example.Bookstore.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private UserService userService;

    // Lấy tất cả User
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Tạo User mới
//    @PostMapping
//    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto) {
//        UserDTO savedUser = userService.createUser(userDto);
//
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//    }

    // Cập nhật User
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable long id, @RequestBody UserDTO updatedUser) {
        UserDTO userDto = userService.updateUser(id,updatedUser);
        return ResponseEntity.ok(userDto);
    }

    // Xóa User
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}")
    public ResponseEntity<Void> changeUserStatus(
            @PathVariable Long id,
            @RequestParam boolean active
    ) {
        userService.changeUserStatus(id, active);
        return ResponseEntity.noContent().build();
    }

    // Lấy User theo ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id) {
        UserDTO savedUser = userService.getUserById(id);
        return ResponseEntity.ok(savedUser);
    }
}
