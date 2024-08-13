package com.book.books.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private  Long id;
    private String name;
    private AuthorDto author;
    private Set<TypeDto> types;
}
