package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.BookDTO;
import com.example.Bookstore.model.Book;

public class BookMapper {

    public static BookDTO mapToBookDTO(Book book) {
        if (book == null) return null;

        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setDescription(book.getDescription());
        dto.setOriginalPrice(book.getOriginalPrice());
        dto.setStockQuantity(book.getStockQuantity());
        dto.setSoldQuantity(book.getSoldQuantity());
        dto.setPublisher(book.getPublisher());
        dto.setPublishedDate(book.getPublishedDate());
        dto.setImageUrls(book.getImageUrls());
        dto.setActive(book.getIsActive());

        // category info
        if (book.getCategory() != null) {
            dto.setCategoryId(book.getCategory().getId());
            dto.setCategoryName(book.getCategory().getName());
        }

        return dto;
    }

    public static Book mapToBook(BookDTO dto) {
        if (dto == null) return null;

        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setDescription(dto.getDescription());
        book.setOriginalPrice(dto.getOriginalPrice());
        book.setStockQuantity(dto.getStockQuantity());
        book.setSoldQuantity(dto.getSoldQuantity());
        book.setPublisher(dto.getPublisher());
        book.setPublishedDate(dto.getPublishedDate());
        book.setImageUrls(dto.getImageUrls());
        book.setIsActive(
                book.getIsActive() != null ? book.getIsActive() : true
        );

        return book;
    }
}
