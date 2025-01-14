package com.bibliotech.books.application.command;

import com.bibliotech.books.domain.command.CommandHandler;
import com.bibliotech.books.domain.command.UpdateBookCommand;
import com.bibliotech.books.domain.entity.AggregateRoot;
import com.bibliotech.books.domain.usecase.UpdateBookUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class UpdateCommandHandler implements CommandHandler<UpdateBookCommand> {

    private final UpdateBookUseCase updateBookUseCase;

    @Override
    public AggregateRoot<?> execute(UpdateBookCommand command) {
        return updateBookUseCase.update(command);
    }
}
