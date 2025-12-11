package com.example.Bookstore.controller;

import com.example.Bookstore.dto.BookDto;
import com.example.Bookstore.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private  BookService bookService;

    // Lấy tất cả sách
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // Lấy sách theo ID
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable long id) {
        BookDto savedBook = bookService.getBookById(id);
        return ResponseEntity.ok(savedBook);
    }

    // Thêm sách mới
    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        BookDto savedBook = bookService.createBook(bookDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // Cập nhật sách
    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable long id, @RequestBody BookDto updatedBook) {
        BookDto bookDto = bookService.updateBook(id,updatedBook);
        return ResponseEntity.ok(bookDto);
    }

    // Xóa sách
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully!!!");
    }
}
