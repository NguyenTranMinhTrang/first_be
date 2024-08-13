package com.book.books.converter;

import com.book.books.dto.AuthorDto;
import com.book.books.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {

    public AuthorDto convertToAuthorDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setFullName(author.getFullName());
        return authorDto;
    }
}
