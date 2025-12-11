package com.example.Bookstore.dto;

import com.example.Bookstore.model.User;
import com.example.Bookstore.model.enums.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    private String username;

    private String email;

    private String fullName;

    private String phone;

    private String address;

    private Role role;

    private boolean isActive;

    public static UserDTO fromEntity(User user) {
        if (user == null) return null;

        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .phone(user.getPhone())
                .address(user.getAddress())
                .role(user.getRole())
                .isActive(user.isActive())
                .build();
    }

    public User toEntity() {
        User user = new User();

        user.setId(this.id);
        user.setUsername(this.username);
        user.setEmail(this.email);
        user.setFullName(this.fullName);
        user.setPhone(this.phone);
        user.setAddress(this.address);
        user.setRole(this.role);
        user.setActive(this.isActive);

        return user;
    }
}
