package com.example.Bookstore.service.impl;

import com.example.Bookstore.mapper.BookMapper;
import com.example.Bookstore.dto.BookDTO;
import com.example.Bookstore.exception.ResourceNotFoundException;
import com.example.Bookstore.model.Book;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private  BookRepository bookRepository;

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(book -> BookMapper.mapToBookDto(book))
                .collect(Collectors.toList());

    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book  = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found " + id));
        return BookMapper.mapToBookDto(book);

    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book is not exists with given id: " + id));
        this.bookRepository.deleteById(id);
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO updatedBook) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book is not exists with given id: " + id));
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setPrice(updatedBook.getPrice());
        book.setStock(updatedBook.getStock());
        book.setDescription(updatedBook.getDescription());
        book.setImage(updatedBook.getImage());
        book.setCategories(updatedBook.getCategories());

        return BookMapper.mapToBookDto(book);
    }

    @Override
    public BookDTO createBook(BookDTO bookDto) {
        Book book = BookMapper.mapToBook(bookDto);
        Book savedBook = bookRepository.save(book);
        return BookMapper.mapToBookDto(savedBook);
    }


}
