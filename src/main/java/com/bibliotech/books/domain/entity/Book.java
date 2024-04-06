package com.bibliotech.books.domain.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends AggregateRoot<BookID> {

    private final Title title;
    private final Authors authors;

    private Book(BookID bookID, Title title, Authors authors) {
        super(bookID);
        this.title = title;
        this.authors = authors;
    }

    @Valid
    public static Book create(
            @NotNull BookID id,
            @NotNull Title title,
            @NotNull Authors authors
    ) {
        return new Book(
                id,
                title,
                authors
        );
    }
}

