package com.bibliotech.books.domain.command;

import com.bibliotech.books.domain.entity.AggregateRoot;

import java.lang.reflect.ParameterizedType;

public interface CommandHandler<T extends Command> {

    AggregateRoot<?> execute(T command);

    default Class<T> listenTo() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericInterfaces()[0];
        return (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }
}
