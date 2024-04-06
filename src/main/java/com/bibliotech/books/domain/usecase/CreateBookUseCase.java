package com.bibliotech.books.domain.usecase;

import com.bibliotech.books.domain.command.CreateBookCommand;
import jakarta.validation.Valid;

public interface CreateBookUseCase {

    void create(@Valid CreateBookCommand command);

}
