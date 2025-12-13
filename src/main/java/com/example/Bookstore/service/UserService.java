package com.example.Bookstore.service;

import com.example.Bookstore.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO register(UserDTO userDto);

    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Long id, UserDTO userDto);
    void deleteUser(Long id);
}
