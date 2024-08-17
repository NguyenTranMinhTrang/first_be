package com.book.books.mapper;

import com.book.books.dto.AuthorDto;
import com.book.books.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto authorToAuthorDto(Author author);
}
