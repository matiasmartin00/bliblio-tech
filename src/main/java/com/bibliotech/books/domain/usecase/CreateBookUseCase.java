package com.bibliotech.books.domain.usecase;

import com.bibliotech.books.domain.command.CreateBookCommand;
import com.bibliotech.books.domain.entity.AggregateRoot;
import com.bibliotech.books.domain.entity.Book;
import jakarta.validation.Valid;

public interface CreateBookUseCase {

    Book create(@Valid CreateBookCommand command);

}
