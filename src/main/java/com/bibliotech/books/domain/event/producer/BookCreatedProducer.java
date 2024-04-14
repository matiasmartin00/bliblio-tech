package com.bibliotech.books.domain.event.producer;

import com.bibliotech.books.domain.event.BookCreatedEvent;

public interface BookCreatedProducer {

    void send(BookCreatedEvent event);
}
