package com.bibliotech.books.domain.event;

import com.bibliotech.books.domain.entity.AggregateRoot;

public interface EventBus {

    void send(AggregateRoot<?> event);
}
