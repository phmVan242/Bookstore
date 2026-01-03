package com.example.Bookstore.service;

import com.example.Bookstore.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO createUser(UserDTO dto);

    UserDTO updateUser(Long id, UserDTO dto);

    void changeUserStatus(Long id, boolean active);

    UserDTO getMyInfor();
}
