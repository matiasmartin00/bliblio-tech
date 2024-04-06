package com.bibliotech.books.application.usecase;

import com.bibliotech.books.domain.command.UpdateBookCommand;
import com.bibliotech.books.domain.repository.UpdateBookRepository;
import com.bibliotech.books.domain.usecase.UpdateBookUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateBookUseCaseImpl implements UpdateBookUseCase {

    private final UpdateBookRepository updateBookRepository;

    @Override
    public void update(UpdateBookCommand command) {

    }
}
