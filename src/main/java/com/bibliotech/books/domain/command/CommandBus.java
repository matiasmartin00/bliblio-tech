package com.bibliotech.books.domain.command;

public interface CommandBus {

    void execute(Command command);
}
