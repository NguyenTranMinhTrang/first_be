package com.book.books.service.implement;

import com.book.books.converter.BookConverter;
import com.book.books.dto.BookDataPostDto;
import com.book.books.dto.BookDto;
import com.book.books.entity.Author;
import com.book.books.entity.Book;
import com.book.books.entity.Type;
import com.book.books.exception.AppException;
import com.book.books.exception.ErrorCode;
import com.book.books.repository.AuthorRepository;
import com.book.books.repository.BookRepository;
import com.book.books.repository.TypeRepository;
import com.book.books.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService implements BookServiceInterface {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookConverter bookConverter;

    @Override
    public BookDto addBook(BookDataPostDto book) {
        List<Type> findTypes = typeRepository.findAllById(book.getTypeIds());

        if (findTypes.isEmpty()) {
            throw new RuntimeException("No types found for the given ids");
        }

        Set<Type> types = new HashSet<>(findTypes);
        Author author = authorRepository.findOneById(book.getAuthorId());

        Book bookEntity = bookConverter.convertToEntity(book);
        bookEntity.setAuthor(author);
        bookEntity.setTypes(types);

        bookRepository.save(bookEntity);
        return bookConverter.convertToDto(bookEntity);
    }

    @Override
    public List<BookDto> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.BOOK_NOT_FOUND));
        return bookConverter.convertToDto(book);
    }

    @Override
    public BookDto updateBook(BookDataPostDto book, Long id) {
        Book bookEntity = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getName() != null && !book.getName().isEmpty()) {
            bookEntity.setName(book.getName());
        }

        if (book.getAuthorId() != null) {
            Author author = authorRepository.findOneById(book.getAuthorId());
            bookEntity.setAuthor(author);
        }

        if (book.getTypeIds() != null) {
            List<Type> findTypes = typeRepository.findAllById(book.getTypeIds());
            Set<Type> types = new HashSet<>(findTypes);
            bookEntity.setTypes(types);
        }

        return bookConverter.convertToDto(bookRepository.save(bookEntity));
    }

    @Override
    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "OK";
    }
}
