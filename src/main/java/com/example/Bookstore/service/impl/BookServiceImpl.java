package com.example.Bookstore.service.impl;

import com.example.Bookstore.dto.BookDTO;
import com.example.Bookstore.exception.ResourceNotFoundException;
import com.example.Bookstore.mapper.BookMapper;
import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.repository.BookRepository;
import com.example.Bookstore.repository.CategoryRepository;
import com.example.Bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + id));
        return BookMapper.mapToBookDTO(book);
    }

    @Override
    public BookDTO createBook(BookDTO dto) {
        Book book = BookMapper.mapToBook(dto);

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found with id: " + dto.getCategoryId()));

        book.setCategory(category);

        Book savedBook = bookRepository.save(book);
        return BookMapper.mapToBookDTO(savedBook);
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + id));

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setDescription(dto.getDescription());
        book.setOriginalPrice(dto.getOriginalPrice());
        book.setStockQuantity(dto.getStockQuantity());
        book.setPublisher(dto.getPublisher());
        book.setPublishedDate(dto.getPublishedDate());
        book.setIsActive(dto.getActive());

        if (dto.getCategoryId() != null) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Category not found with id: " + dto.getCategoryId()));
            book.setCategory(category);
        }

        return BookMapper.mapToBookDTO(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + id));
        bookRepository.delete(book);
    }
}
