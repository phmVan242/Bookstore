package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.OrderDto;
import com.example.Bookstore.dto.UserDto;
import com.example.Bookstore.model.User;

import java.util.stream.Collectors;

public class UserMapper {

    // Entity -> DTO
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFullName(),
                user.getPhone(),
                user.getRole(),
                user.isStatus(),
                user.getCart() != null ? user.getCart().getId() : null,
                user.getOrders() != null ? user.getOrders().stream()
                        .map(OrderMapper::mapToOrderDto)
                        .collect(Collectors.toList()) : null
        );
    }

    // DTO -> Entity
    public static User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setPhone(userDto.getPhone());
        user.setRole(userDto.getRole());
        user.setStatus(userDto.isStatus());
        return user;
    }
}
