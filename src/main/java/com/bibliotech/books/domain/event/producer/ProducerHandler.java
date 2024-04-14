package com.bibliotech.books.domain.event.producer;

import com.bibliotech.books.domain.event.DomainEvent;

import java.lang.reflect.ParameterizedType;

public interface ProducerHandler<E extends DomainEvent> {

    void send(E event);

    default Class<E> listenTo() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericInterfaces()[0];
        return (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }
}
