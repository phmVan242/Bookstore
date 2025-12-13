package com.example.Bookstore.dto;

import com.example.Bookstore.model.enums.BlogStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {

    private Long id;

    @NotBlank(message = "Blog title is required")
    @Size(min = 5, max = 200, message = "Blog title must be between 5 and 200 characters")
    private String title;

    @NotBlank(message = "Blog content is required")
    private String content;

    private String imageUrl;

    @NotNull(message = "User is required")
    private Long userId;

    private String authorName;

    @NotNull(message = "Blog status is required")
    private BlogStatus status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishedDate;

    private String publishedDateFormatted;
}
