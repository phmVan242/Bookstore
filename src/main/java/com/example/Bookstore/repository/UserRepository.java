package com.example.Bookstore.repository;

import com.example.Bookstore.model.Role;
import com.example.Bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
    Optional<User> findFirstByUsername(String username);
//    Optional<User> findByEmail(String email);
    Optional<User> findFirstByEmail(String email);
    Optional<User> findByRole(Role role);

}
