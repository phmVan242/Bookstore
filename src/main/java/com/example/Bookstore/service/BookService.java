package com.example.Bookstore.service;

import com.example.Bookstore.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    void deleteBook(Long id);
    BookDTO updateBook(Long id, BookDTO updatedBook);
    BookDTO createBook(BookDTO bookDto);
}
