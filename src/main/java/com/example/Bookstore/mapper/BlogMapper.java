package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.BlogDTO;
import com.example.Bookstore.model.Blog;

import java.time.format.DateTimeFormatter;

public class BlogMapper {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static BlogDTO mapToBlogDTO(Blog blog) {
        if (blog == null) return null;

        BlogDTO dto = new BlogDTO();
        dto.setId(blog.getId());
        dto.setTitle(blog.getTitle());
        dto.setContent(blog.getContent());
        dto.setImageUrl(blog.getImageUrl());
        dto.setStatus(blog.getStatus());
        dto.setPublishedDate(blog.getPublishedDate());

        // user info (chỉ expose dữ liệu cần thiết)
        if (blog.getUser() != null) {
            dto.setUserId(blog.getUser().getId());
            dto.setAuthorName(blog.getUser().getFullName());
            // ⚠️ đổi getFullName() theo User entity của bạn
        }

        // formatted date cho FE
        if (blog.getPublishedDate() != null) {
            dto.setPublishedDateFormatted(
                    blog.getPublishedDate().format(FORMATTER)
            );
        }

        return dto;
    }

    public static Blog mapToBlog(BlogDTO dto) {
        if (dto == null) return null;

        Blog blog = new Blog();
        blog.setId(dto.getId());
        blog.setTitle(dto.getTitle());
        blog.setContent(dto.getContent());
        blog.setImageUrl(dto.getImageUrl());
        blog.setStatus(dto.getStatus());
        blog.setPublishedDate(dto.getPublishedDate());

        return blog;
    }
}
