package com.bibliotech.books.boot.command;

import com.bibliotech.books.domain.command.Command;
import com.bibliotech.books.domain.command.CommandBus;
import com.bibliotech.books.domain.command.CommandHandler;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
@Dependent
public class CommandBusImpl<C extends Command> implements CommandBus {

    private final Map<Class<C>, CommandHandler<C>> commandHandlers;

    @Inject
    public CommandBusImpl(@Any Instance<CommandHandler<? extends Command>> commandHandlers) {
        Map<Class<C>, CommandHandler<C>> temp = new HashMap<>();
        commandHandlers.forEach(handler -> {
            temp.put((Class<C>) handler.listenTo(), (CommandHandler<C>) handler);
        });
        this.commandHandlers = Collections.unmodifiableMap(temp);
    }

    @Override
    public void execute(Command command) {
        var handler = Optional.ofNullable(commandHandlers.get(command.getClass()))
                .orElseThrow(() -> new RuntimeException("Command can't be handler " + command.getClass().getSimpleName()));
        handler.execute((C) command);
    }
}
