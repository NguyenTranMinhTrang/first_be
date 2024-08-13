package com.book.books.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book extends BaseEntity{

    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "books_types",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    Set<Type> types = new HashSet<Type>();

    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    private Author author;
}
