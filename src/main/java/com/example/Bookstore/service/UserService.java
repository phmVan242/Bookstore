package com.example.Bookstore.service;

import com.example.Bookstore.dto.UserDto;
import com.example.Bookstore.model.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
}
