package com.bibliotech.books.infrastructure.messaging.producer;

import com.bibliotech.books.domain.event.BookCreatedEvent;
import com.bibliotech.books.domain.event.BookDeletedEvent;
import com.bibliotech.books.domain.event.producer.BookCreatedProducer;
import com.bibliotech.books.domain.event.producer.BookDeletedProducer;
import com.bibliotech.books.domain.event.producer.ProducerHandler;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class BookDeletedProducerHandler implements ProducerHandler<BookDeletedEvent> {

    private final BookDeletedProducer bookDeletedProducer;

    @Override
    public void send(BookDeletedEvent event) {
        bookDeletedProducer.send(event);
    }
}
