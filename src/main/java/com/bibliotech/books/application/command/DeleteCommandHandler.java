package com.bibliotech.books.application.command;

import com.bibliotech.books.domain.command.CommandHandler;
import com.bibliotech.books.domain.command.DeleteBookCommand;
import com.bibliotech.books.domain.entity.AggregateRoot;
import com.bibliotech.books.domain.usecase.DeleteBookUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class DeleteCommandHandler implements CommandHandler<DeleteBookCommand> {

    private final DeleteBookUseCase deleteBookUseCase;

    @Override
    public AggregateRoot<?> execute(DeleteBookCommand command) {
        return deleteBookUseCase.delete(command);
    }
}

