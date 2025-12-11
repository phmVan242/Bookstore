package com.example.Bookstore.service;

import com.example.Bookstore.dto.SignupRequest;
import com.example.Bookstore.dto.UserDto;

public interface AuthService    {
    UserDto createUser(SignupRequest signupRequest);
}

