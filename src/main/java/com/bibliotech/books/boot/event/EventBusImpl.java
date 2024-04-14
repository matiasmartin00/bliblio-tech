package com.bibliotech.books.boot.event;

import com.bibliotech.books.domain.command.Command;
import com.bibliotech.books.domain.command.CommandHandler;
import com.bibliotech.books.domain.entity.AggregateRoot;
import com.bibliotech.books.domain.event.BookCreatedEvent;
import com.bibliotech.books.domain.event.DomainEvent;
import com.bibliotech.books.domain.event.EventBus;
import com.bibliotech.books.domain.event.producer.BookCreatedProducer;
import com.bibliotech.books.domain.event.producer.BookDeletedProducer;
import com.bibliotech.books.domain.event.producer.BookUpdatedProducer;
import com.bibliotech.books.domain.event.producer.ProducerHandler;
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
@RequiredArgsConstructor
public class EventBusImpl<E extends DomainEvent> implements EventBus {

    private final Map<Class<E>, ProducerHandler<E>> handlers;

    @Inject
    public EventBusImpl(@Any Instance<ProducerHandler<? extends DomainEvent>> eventHandlers) {
        Map<Class<E>, ProducerHandler<E>> temp = new HashMap<>();
        eventHandlers.forEach(handler -> {
            temp.put((Class<E>) handler.listenTo(), (ProducerHandler<E>) handler);
        });
        this.handlers = Collections.unmodifiableMap(temp);
    }

    @Override
    public void send(AggregateRoot<?> aggregateRoot) {
        aggregateRoot.getDomainEvents()
                .forEach(de -> {
                    var handler = handlers.get(de.getClass());
                    if (Objects.isNull(handler)) {
                        log.warn("handler not found for {}", de.getClass());
                        return;
                    }

                    handler.send((E) de);
                });
    }
}
