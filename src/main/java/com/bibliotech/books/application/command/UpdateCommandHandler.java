package com.bibliotech.books.application.command;

import com.bibliotech.books.domain.command.CommandHandler;
import com.bibliotech.books.domain.command.UpdateBookCommand;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class UpdateCommandHandler implements CommandHandler<UpdateBookCommand> {
    @Override
    public void execute(UpdateBookCommand command) {

    }
}
