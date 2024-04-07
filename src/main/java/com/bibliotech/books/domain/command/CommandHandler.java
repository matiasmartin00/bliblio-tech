package com.bibliotech.books.domain.command;

import java.lang.reflect.ParameterizedType;

public interface CommandHandler<T extends Command> {

    void execute(T command);

    default Class<T> listenTo() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericInterfaces()[0];
        return (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }
}
