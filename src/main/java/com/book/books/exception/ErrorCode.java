package com.book.books.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    BOOK_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Book not found"),
    ;

    private int statusCode;
    private String message;

    ErrorCode(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}