package com.bibliotech.books.application.usecase;

import com.bibliotech.books.domain.command.UpdateBookCommand;
import com.bibliotech.books.domain.entity.Author;
import com.bibliotech.books.domain.entity.Authors;
import com.bibliotech.books.domain.entity.Title;
import com.bibliotech.books.domain.query.GetByIDQuery;
import com.bibliotech.books.domain.repository.UpdateBookRepository;
import com.bibliotech.books.domain.usecase.GetBookByIDUseCase;
import com.bibliotech.books.domain.usecase.UpdateBookUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class UpdateBookUseCaseImpl implements UpdateBookUseCase {

    private final UpdateBookRepository updateBookRepository;
    private final GetBookByIDUseCase getBookByIDUseCase;

    @Override
    public void update(UpdateBookCommand command) {
        var bookId = new GetByIDQuery(command.id());
        var book = getBookByIDUseCase.getByID(bookId);
        var title = new Title(command.title());
        final var authorsSet = command.authors()
                .stream()
                .map(Author::new)
                .collect(Collectors.toSet());
        final var authors = new Authors(authorsSet);
        book.update(title, authors);
        updateBookRepository.update(book);
    }
}
