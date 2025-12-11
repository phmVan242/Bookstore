package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.BookDTO;
import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.Category;

public class BookMapper {

    public BookDTO toDTO(Book book) {
        if (book == null) return null;

        BookDTO dto = new BookDTO();

        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setDescription(book.getDescription());
        dto.setOriginalPrice(book.getOriginalPrice());
        dto.setSalePrice(book.getSalePrice());
        dto.setStockQuantity(book.getStockQuantity());
        dto.setSoldQuantity(book.getSoldQuantity());
        dto.setPublisher(book.getPublisher());
        dto.setPublishedDate(book.getPublishedDate());
        dto.setImageUrls(book.getImageUrls());
        dto.setCategoryId(book.getCategory() != null ? book.getCategory().getId() : null);
        dto.setActive(book.isActive());

        return dto;
    }

    public Book toEntity(BookDTO dto) {
        if (dto == null) return null;

        Book book = new Book();

        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setDescription(dto.getDescription());
        book.setOriginalPrice(dto.getOriginalPrice());
        book.setSalePrice(dto.getSalePrice());
        book.setStockQuantity(dto.getStockQuantity());
        book.setSoldQuantity(dto.getSoldQuantity());
        book.setPublisher(dto.getPublisher());
        book.setPublishedDate(dto.getPublishedDate());
        book.setImageUrls(dto.getImageUrls());
        book.setActive(dto.isActive());

        // Category chỉ set id để tránh query thừa
        if (dto.getCategoryId() != null) {
            Category c = new Category();
            c.setId(dto.getCategoryId());
            book.setCategory(c);
        }

        return book;
    }
}