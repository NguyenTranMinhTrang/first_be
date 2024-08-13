package com.book.books.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDataPostDto {
    private String name;

    private Long authorId;

    @Size(min = 1, message = "Book must have at least one type")
    private List<Long> typeIds;
}
