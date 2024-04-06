package com.bibliotech.books.application.usecase;

import com.bibliotech.books.domain.command.CreateBookCommand;
import com.bibliotech.books.domain.entity.*;
import com.bibliotech.books.domain.usecase.CreateBookUseCase;

import java.util.Set;
import java.util.stream.Collectors;

public class CreateBookUseCaseImpl implements CreateBookUseCase {

    @Override
    public void create(CreateBookCommand command) {
        final var id = new BookID(command.id());
        final var title = new Title(command.title());
        final var authorsSet = command.authors()
                .stream()
                .map(Author::new)
                .collect(Collectors.toSet());
        final var authors = new Authors(authorsSet);
        final var book = Book.create(
                id,
                title,
                authors
        );
        //save
    }
}
