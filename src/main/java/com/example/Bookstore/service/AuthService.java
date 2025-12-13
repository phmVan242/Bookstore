package com.example.Bookstore.service;

import com.example.Bookstore.dto.SignupRequest;
import com.example.Bookstore.dto.UserDTO;

public interface AuthService    {
    UserDTO createUser(SignupRequest signupRequest);
}

