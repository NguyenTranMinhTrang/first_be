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
@Table(name = "authors")
public class Author extends BaseEntity {
    @Column
    private  String fullName;

    @OneToMany(mappedBy="author")
    private Set<Book> books = new HashSet<>();
}
