package com.bibliotech.books.infrastructure.messaging.producer;

import com.bibliotech.books.domain.event.BookCreatedEvent;
import com.bibliotech.books.domain.event.BookUpdatedEvent;
import com.bibliotech.books.domain.event.producer.BookCreatedProducer;
import com.bibliotech.books.domain.event.producer.BookUpdatedProducer;
import com.bibliotech.books.domain.event.producer.ProducerHandler;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class BookUpdatedProducerHandler implements ProducerHandler<BookUpdatedEvent> {

    private final BookUpdatedProducer bookUpdatedProducer;

    @Override
    public void send(BookUpdatedEvent event) {
        bookUpdatedProducer.send(event);
    }
}
