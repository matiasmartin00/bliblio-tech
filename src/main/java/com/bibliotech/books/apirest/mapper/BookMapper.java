package com.bibliotech.books.apirest.mapper;

import com.bibliotech.books.apirest.dto.BookDTO;
import com.bibliotech.books.domain.command.CreateBookCommand;
import com.bibliotech.books.domain.entity.Authors;
import com.bibliotech.books.domain.entity.Book;
import com.bibliotech.books.domain.entity.BookID;
import com.bibliotech.books.domain.entity.ValueObject;
import com.bibliotech.books.domain.query.GetByIDQuery;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class BookMapper {

    public static CreateBookCommand map(BookDTO dto) {
        return new CreateBookCommand(
                dto.id(),
                dto.title(),
                dto.authors()
        );
    }

    public static GetByIDQuery map(UUID id) {
        return new GetByIDQuery(id);
    }

    public static BookDTO map(Book src) {
        return new BookDTO(
                map(src.getId()),
                map(src.getTitle()),
                map(src.getAuthors())
        );
    }

    private static Set<String> map(Authors src) {
        return src.value()
                .stream()
                .map(BookMapper::map)
                .collect(Collectors.toSet());
    }

    private static <R> R map(ValueObject<R> val) {
        if (isNull(val)) {
            return null;
        }

        return val.value();
    }
}
