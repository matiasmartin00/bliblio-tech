package com.bibliotech.books.domain.entity;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class BookTest {

    @Test
    void given_createCommand_when_create_then_book_created() {
        var id = new BookID(UUID.nameUUIDFromBytes("mock-id".getBytes()));
        var title = new Title("some title");
        var author = new Author("some author");
        var authors = new Authors(Set.of(author));
        var book = Book.create(
                id,
                title,
                authors
        );

        assertThat(book)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", id)
                .hasFieldOrPropertyWithValue("title", title)
                .hasFieldOrPropertyWithValue("authors", authors);
        assertThat(book.metadata).isNotNull();
        assertThat(book.metadata.createdAt()).isNotNull();
        assertThat(book.metadata.createdBy()).isNotNull();
        assertThat(book.metadata.modifiedAt()).isNull();
        assertThat(book.metadata.modifiedBy()).isNull();
        assertThat(book.metadata.deletedAt()).isNull();
        assertThat(book.metadata.deletedBy()).isNull();
    }
}
