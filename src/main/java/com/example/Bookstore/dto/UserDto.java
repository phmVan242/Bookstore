package com.example.Bookstore.dto;

import com.example.Bookstore.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String phone;
    private Role role;
    private boolean status;
    private Long cartId;
    private List<OrderDto> orders;
}
