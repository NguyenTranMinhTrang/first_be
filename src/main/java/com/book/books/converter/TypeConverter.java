package com.book.books.converter;

import com.book.books.dto.TypeDto;
import com.book.books.entity.Type;
import org.springframework.stereotype.Component;

@Component
public class TypeConverter {
    public TypeDto toDto(Type type) {
        TypeDto typeDto = new TypeDto();
        typeDto.setId(type.getId());
        typeDto.setName(type.getName());
        return typeDto;
    }
}
