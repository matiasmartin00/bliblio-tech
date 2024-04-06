package com.bibliotech.books.domain.usecase;

import com.bibliotech.books.domain.command.UpdateBookCommand;

public interface UpdateBookUseCase {

    void update(UpdateBookCommand command);
}
