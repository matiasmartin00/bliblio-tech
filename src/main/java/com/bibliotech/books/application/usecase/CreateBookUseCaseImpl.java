package com.bibliotech.books.application.usecase;

import com.bibliotech.books.domain.command.CreateBookCommand;
import com.bibliotech.books.domain.entity.*;
import com.bibliotech.books.domain.repository.CreateBookRepository;
import com.bibliotech.books.domain.usecase.CreateBookUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class CreateBookUseCaseImpl implements CreateBookUseCase {

    private final CreateBookRepository createBookRepository;

    @Override
    public Book create(CreateBookCommand command) {
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

        createBookRepository.create(book);
        return book;
    }
}
