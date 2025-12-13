package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.UserDTO;
import com.example.Bookstore.model.User;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user) {
        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setPhone(user.getPhone());
        dto.setAddress(user.getAddress());
        dto.setRole(user.getRole());
        dto.setActive(user.isActive());

        return dto;
    }

    public static User mapToUser(UserDTO dto) {
        if (dto == null) return null;

        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setFullName(dto.getFullName());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());
        user.setRole(dto.getRole());
        user.setActive(dto.isActive());
        // ❗ password, orders, blogs, cart xử lý riêng

        return user;
    }
}
