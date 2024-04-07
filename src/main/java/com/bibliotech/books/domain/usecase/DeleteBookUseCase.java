package com.bibliotech.books.domain.usecase;

import com.bibliotech.books.domain.command.DeleteBookCommand;
import com.bibliotech.books.domain.entity.Book;

public interface DeleteBookUseCase {

    void delete(DeleteBookCommand command);
}