package com.bibliotech.books.domain.event.producer;

import com.bibliotech.books.domain.event.BookCreatedEvent;
import com.bibliotech.books.domain.event.BookUpdatedEvent;

public interface BookUpdatedProducer {

    void send(BookUpdatedEvent event);
}
