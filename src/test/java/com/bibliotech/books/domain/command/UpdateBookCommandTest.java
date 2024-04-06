package com.bibliotech.books.domain.command;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UpdateBookCommandTest {

    @Test
    void given_id_title_authors_when_new_then_command() {
        var id = UUID.nameUUIDFromBytes("mock-id".getBytes());
        var title = "Some title";
        var authors = Set.of("Some author", "Second author");
        var command = new UpdateBookCommand(
                id,
                title,
                authors
        );

        assertThat(command).isNotNull();
        assertThat(command.id()).isEqualTo(id);
        assertThat(command.authors()).isEqualTo(authors);
        assertThat(command.title()).isEqualTo(title);
    }
}
