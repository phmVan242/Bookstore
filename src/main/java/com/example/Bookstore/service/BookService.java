package com.example.Bookstore.service;

import com.example.Bookstore.dto.BookDto;
import com.example.Bookstore.model.Book;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks();
    BookDto getBookById(Long id);
    void deleteBook(Long id);
    BookDto updateBook(Long id, BookDto updatedBook);
    BookDto createBook(BookDto bookDto);
}
