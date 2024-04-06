package com.bibliotech.books.domain.entity;

import com.bibliotech.books.domain.entity.metadata.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends AggregateRoot<BookID> {

    private Title title;
    private Authors authors;

    private Book(BookID bookID, Title title, Authors authors, Metadata metadata) {
        super(bookID, metadata);
        this.title = title;
        this.authors = authors;
    }

    public static Book create(
            @NotNull BookID id,
            @NotNull Title title,
            @NotNull Authors authors
    ) {
        final var metadata = Metadata.builder()
                .createdBy(new CreatedBy("system")) // CHANGE ME
                .createdAt(new CreatedAt(LocalDateTime.now()))
                .build();

        return new Book(
                id,
                title,
                authors,
                metadata
        );
    }

    public void update(
            @NotNull Title title,
            @NotNull Authors authors
    ) {
        final var metadata = getMetadata().toBuilder()
                .modifiedBy(new ModifiedBy("system")) // CHANGE ME
                .modifiedAt(new ModifiedAt(LocalDateTime.now()))
                .build();

        this.title = title;
        this.authors = authors;
        this.metadata = metadata;
    }
}

