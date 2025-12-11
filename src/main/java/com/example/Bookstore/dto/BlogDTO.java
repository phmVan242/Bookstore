package com.example.Bookstore.dto;

import com.example.Bookstore.model.Blog;
import com.example.Bookstore.model.User;
import com.example.Bookstore.model.enums.BlogStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {

    private Long id;

    @NotBlank(message = "Blog title is required")
    private String title;

    @NotBlank(message = "Blog content is required")
    private String content;

    private String imageUrl;

    @NotNull(message = "User is required")
    private Long userId;

    private String username;

    @NotNull(message = "Status is required")
    private BlogStatus status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishedDate;

    public static BlogDTO fromEntity(Blog blog) {
        return BlogDTO.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .content(blog.getContent())
                .imageUrl(blog.getImageUrl())
                .userId(blog.getUser() != null ? blog.getUser().getId() : null)
                .username(blog.getUser() != null ? blog.getUser().getUsername() : null)
                .status(blog.getStatus())
                .publishedDate(blog.getPublishedDate())
                .build();
    }

    public Blog toEntity() {
        Blog blog = new Blog();

        blog.setId(this.id);
        blog.setTitle(this.title);
        blog.setContent(this.content);
        blog.setImageUrl(this.imageUrl);
        blog.setStatus(this.status);
        blog.setPublishedDate(this.publishedDate);

        if (this.userId != null) {
            User user = new User();
            user.setId(this.userId);
            blog.setUser(user);
        }

        return blog;
    }
}
