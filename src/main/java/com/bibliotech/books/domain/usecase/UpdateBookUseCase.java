package com.bibliotech.books.domain.usecase;

import com.bibliotech.books.domain.command.UpdateBookCommand;
import com.bibliotech.books.domain.entity.Book;

public interface UpdateBookUseCase {

    Book update(UpdateBookCommand command);
}
