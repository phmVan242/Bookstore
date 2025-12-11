package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.SignupRequest;
import com.example.Bookstore.dto.UserDto;
import com.example.Bookstore.mapper.UserMapper;
import com.example.Bookstore.model.Cart;
import com.example.Bookstore.model.Role;
import com.example.Bookstore.model.User;
import com.example.Bookstore.repository.UserRepository;
import com.example.Bookstore.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(SignupRequest signupRequest) {
        if(userRepository.findFirstByUsername(signupRequest.getUsername()).isPresent()){
            throw new RuntimeException("User already present with email " + signupRequest.getUsername());
        }
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setFullName(signupRequest.getFullName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setPhone(signupRequest.getPhone());
        user.setRole(Role.USER);
        user.setStatus(true);
        //Tạo cart cho user
        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);

        User createdUser = userRepository.save(user);
        return UserMapper.mapToUserDto(createdUser);
    }
}

