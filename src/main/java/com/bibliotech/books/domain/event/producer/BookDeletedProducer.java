package com.bibliotech.books.domain.event.producer;

import com.bibliotech.books.domain.event.BookCreatedEvent;
import com.bibliotech.books.domain.event.BookDeletedEvent;

public interface BookDeletedProducer {

    void send(BookDeletedEvent event);
}
