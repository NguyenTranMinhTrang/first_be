package com.book.books.mapper;

import com.book.books.dto.BookDataPostDto;
import com.book.books.dto.BookDto;
import com.book.books.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBook(BookDataPostDto book);
    BookDto toBookDto(Book book);
}
