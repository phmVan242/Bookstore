package com.example.Bookstore.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseModel {

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @Column(name = "is_active")
    private boolean isActive = true;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();


}
