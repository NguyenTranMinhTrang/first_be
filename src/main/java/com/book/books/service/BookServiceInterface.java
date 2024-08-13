package com.book.books.service;

import com.book.books.dto.BookDataPostDto;
import com.book.books.dto.BookDto;

import java.util.List;

public interface BookServiceInterface {
    BookDto addBook(BookDataPostDto book);
    List<BookDto> getBooks();
    BookDto getBookById(Long id);
    BookDto updateBook(BookDataPostDto book, Long id);
    String deleteBook(Long id);
}
