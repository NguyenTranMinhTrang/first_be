package com.book.books.repository;

import com.book.books.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findOneById(Long id);
}
