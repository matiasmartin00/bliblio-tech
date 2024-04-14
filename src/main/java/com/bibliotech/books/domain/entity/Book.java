package com.bibliotech.books.domain.entity;

import com.bibliotech.books.domain.entity.metadata.*;
import com.bibliotech.books.domain.event.BookCreatedEvent;
import com.bibliotech.books.domain.event.BookDeletedEvent;
import com.bibliotech.books.domain.event.BookUpdatedEvent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends AggregateRoot<BookID> {

    private Title title;
    private Authors authors;

    @Builder
    public Book(BookID bookID, Title title, Authors authors, Metadata metadata) {
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

        final var book = new Book(
                id,
                title,
                authors,
                metadata
        );

        final var event = new BookCreatedEvent(id);

        book.addEvent(event);

        return book;
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

        final var event = new BookUpdatedEvent(this.getId());

        this.addEvent(event);
    }

    public void delete() {
       this.metadata = getMetadata().toBuilder()
                .deletedBy(new DeletedBy("system"))
                .deletedAt(new DeletedAt(LocalDateTime.now()))
                .build();

       var event = new BookDeletedEvent(this.getId());

       this.addEvent(event);
    }
}

