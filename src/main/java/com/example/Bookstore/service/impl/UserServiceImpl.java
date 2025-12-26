package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.UserDTO;
import com.example.Bookstore.exception.ResourceNotFoundException;
import com.example.Bookstore.mapper.UserMapper;
import com.example.Bookstore.model.User;
import com.example.Bookstore.repository.UserRepository;
import com.example.Bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));
        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO dto) {
        User user = UserMapper.mapToUser(dto);
        user.setActive(true);
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
//        user.setPassword(passwordEncoder.encode());

        return UserMapper.mapToUserDTO(
                userRepository.save(user)
        );
    }

    /**
     * Update thông tin cá nhân (admin hoặc chính user)
     * KHÔNG update role, password, status
     */
    @Override
    public UserDTO updateUser(Long id, UserDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));

        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setAddress(dto.getAddress());

        return UserMapper.mapToUserDTO(
                userRepository.save(user)
        );
    }

    /**
     * Khoá / mở khoá user
     */
    @Override
    public void changeUserStatus(Long id, boolean active) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));

        user.setActive(active);
        userRepository.save(user);
    }
}
