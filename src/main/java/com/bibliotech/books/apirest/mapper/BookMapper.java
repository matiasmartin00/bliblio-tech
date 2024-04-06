package com.bibliotech.books.apirest.mapper;

import com.bibliotech.books.apirest.dto.BookDTO;
import com.bibliotech.books.domain.command.CreateBookCommand;

public class BookMapper {

    public static CreateBookCommand map(BookDTO dto) {
        return new CreateBookCommand(
                dto.id(),
                dto.title(),
                dto.authors()
        );
    }
}
