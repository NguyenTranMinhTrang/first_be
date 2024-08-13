package com.book.books.controller;

import com.book.books.dto.BookDataPostDto;
import com.book.books.dto.BookDto;
import com.book.books.dto.ResponseDto;
import com.book.books.service.implement.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public ResponseDto<List<BookDto>> getAllBooks() {
        ResponseDto<List<BookDto>> responseDto = new ResponseDto<>();
        responseDto.setResult(bookService.getBooks());
        return responseDto;
    }

    @GetMapping(value = "/book/{id}")
    public ResponseDto<BookDto> getBook(@PathVariable("id") Long id) {
        ResponseDto<BookDto> responseDto = new ResponseDto<>();
        responseDto.setResult(bookService.getBookById(id));
        return responseDto;
    }

    @PostMapping(value = "/create-book")
    public ResponseDto<BookDto> createBook(@RequestBody @Valid BookDataPostDto bookDto) {
        ResponseDto<BookDto> responseDto = new ResponseDto<>();
        responseDto.setResult(bookService.addBook(bookDto));
        return  responseDto;
    }

    @PutMapping(value = "/update-book/{id}")
    public ResponseDto<BookDto> updateBook(@RequestBody BookDataPostDto bookDto, @PathVariable("id") Long id) {
        ResponseDto<BookDto> responseDto = new ResponseDto<>();
        responseDto.setResult(bookService.updateBook(bookDto, id));
        return  responseDto;
    }

    @DeleteMapping(value = "/delete-book")
    public ResponseDto<?> deleteBook(@RequestParam Long id) {
        bookService.deleteBook(id);
        return new ResponseDto<>();
    }
}
