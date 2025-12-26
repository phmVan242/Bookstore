package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.SignupRequest;
import com.example.Bookstore.dto.UserDTO;
import com.example.Bookstore.mapper.UserMapper;
import com.example.Bookstore.model.Cart;
import com.example.Bookstore.model.enums.Role;
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
    public UserDTO createUser(SignupRequest signupRequest) {
        if(userRepository.findFirstByUsername(signupRequest.getUsername()).isPresent()){
            throw new RuntimeException("User already present with email " + signupRequest.getUsername());
        }
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setFullName(signupRequest.getFullName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
//        user.setPassword(signupRequest.getPassword());
        user.setPhone(signupRequest.getPhone());
        user.setAddress(signupRequest.getAddress());
        user.setEmail(signupRequest.getEmail());
        user.setRole(Role.USER);
        user.setActive(true);
//        user.setStatus(true);
        //Tạo cart cho user
        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);

        User createdUser = userRepository.save(user);
        return UserMapper.mapToUserDTO(createdUser);
    }
}

