package com.bibliotech.books.application.command;

import com.bibliotech.books.domain.command.Command;
import com.bibliotech.books.domain.command.CommandHandler;
import com.bibliotech.books.domain.command.CreateBookCommand;
import com.bibliotech.books.domain.entity.AggregateRoot;
import com.bibliotech.books.domain.usecase.CreateBookUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class CreateCommandHandler implements CommandHandler<CreateBookCommand> {

    private final CreateBookUseCase createBookUseCase;

    @Override
    public AggregateRoot<?> execute(CreateBookCommand command) {
        return createBookUseCase.create(command);
    }
}
