package com.book.books.converter;

import com.book.books.dto.AuthorDto;
import com.book.books.dto.BookDataPostDto;
import com.book.books.dto.BookDto;
import com.book.books.dto.TypeDto;
import com.book.books.entity.Book;
import com.book.books.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Component
public class BookConverter {

    @Autowired
    private  AuthorConverter authorConverter;
    @Autowired
    private TypeConverter typeConverter;

    public Book convertToEntity(BookDataPostDto book) {
        Book newBook = new Book();
        newBook.setName(book.getName());
        return newBook;
    }

    public BookDto convertToDto(Book book) {
        BookDto newBookDto = new BookDto();
        newBookDto.setId(book.getId());
        newBookDto.setName(book.getName());

        AuthorDto authorDto = authorConverter.convertToAuthorDto(book.getAuthor());
        newBookDto.setAuthor(authorDto);

        Set<TypeDto> types = new HashSet<>();

        Iterator value = book.getTypes().iterator();
        while (value.hasNext()) {
            TypeDto typeDto = typeConverter.toDto((Type) value.next());
            types.add(typeDto);
        }

        newBookDto.setTypes(types);

        return newBookDto;
    }
}
