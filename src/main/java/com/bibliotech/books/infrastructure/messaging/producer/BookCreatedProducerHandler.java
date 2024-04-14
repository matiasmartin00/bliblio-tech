package com.bibliotech.books.infrastructure.messaging.producer;

import com.bibliotech.books.domain.event.BookCreatedEvent;
import com.bibliotech.books.domain.event.producer.BookCreatedProducer;
import com.bibliotech.books.domain.event.producer.ProducerHandler;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class BookCreatedProducerHandler implements ProducerHandler<BookCreatedEvent> {

    private final BookCreatedProducer bookCreatedProducer;

    @Override
    public void send(BookCreatedEvent event) {
        bookCreatedProducer.send(event);
    }
}
