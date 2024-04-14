package com.bibliotech.books.infrastructure.messaging.producer;

import com.bibliotech.books.domain.event.BookCreatedEvent;
import com.bibliotech.books.domain.event.BookDeletedEvent;
import com.bibliotech.books.domain.event.BookUpdatedEvent;
import com.bibliotech.books.domain.event.DomainEvent;
import com.bibliotech.books.domain.event.producer.BookCreatedProducer;
import com.bibliotech.books.domain.event.producer.BookDeletedProducer;
import com.bibliotech.books.domain.event.producer.BookUpdatedProducer;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class EventProducer implements BookCreatedProducer, BookDeletedProducer, BookUpdatedProducer {

    @Override
    public void send(BookCreatedEvent event) {
        log.info("Created sent -> {}", event);
    }

    @Override
    public void send(BookDeletedEvent event) {
        log.info("Deleted sent -> {}", event);
    }

    @Override
    public void send(BookUpdatedEvent event) {
        log.info("Updated sent -> {}", event);
    }
}
