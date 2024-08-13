package com.book.books.service.implement;

import com.book.books.repository.TypeRepository;
import com.book.books.service.TypeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService implements TypeServiceInterface {

    @Autowired
    private TypeRepository typeRepository;
}
