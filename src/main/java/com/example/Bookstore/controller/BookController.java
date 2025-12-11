package com.example.Bookstore.controller;

import com.example.Bookstore.dto.BookDTO;
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
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // Lấy sách theo ID
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable long id) {
        BookDTO savedBook = bookService.getBookById(id);
        return ResponseEntity.ok(savedBook);
    }

    // Thêm sách mới
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDto) {
        BookDTO savedBook = bookService.createBook(bookDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // Cập nhật sách
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable long id, @RequestBody BookDTO updatedBook) {
        BookDTO bookDto = bookService.updateBook(id,updatedBook);
        return ResponseEntity.ok(bookDto);
    }

    // Xóa sách
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully!!!");
    }
}
