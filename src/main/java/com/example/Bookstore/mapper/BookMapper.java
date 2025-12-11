package com.example.Bookstore.mapper;

import com.example.Bookstore.dto.BookDto;
import com.example.Bookstore.model.Book;

public class BookMapper {

    public static BookDto mapToBookDto(Book book){
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getStock(),
                book.getDescription(),
                book.getImage(),
                book.getCategories()
        );

    }

    public static Book mapToBook(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPrice(bookDto.getPrice());
        book.setStock(bookDto.getStock());
        book.setDescription(bookDto.getDescription());
        book.setImage(bookDto.getImage());
        book.setCategories(bookDto.getCategories());
        return book;
    }

}
