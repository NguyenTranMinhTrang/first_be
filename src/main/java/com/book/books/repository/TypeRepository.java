package com.book.books.repository;

import com.book.books.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findOneById(Long id);
}
