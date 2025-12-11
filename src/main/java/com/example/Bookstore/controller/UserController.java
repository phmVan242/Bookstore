package com.example.Bookstore.controller;

import com.example.Bookstore.dto.UserDto;
import com.example.Bookstore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    // Lấy tất cả User
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Tạo User mới
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Cập nhật User
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable long id, @RequestBody UserDto updatedUser) {
        UserDto userDto = userService.updateUser(id,updatedUser);
        return ResponseEntity.ok(userDto);
    }

    // Xóa User
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully!!!");
    }

    // Lấy User theo ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {
        UserDto savedUser = userService.getUserById(id);
        return ResponseEntity.ok(savedUser);
    }
}
