package com.bibliotech.books.domain.event;

import com.bibliotech.books.domain.entity.BookID;
import jakarta.validation.constraints.NotNull;

public record BookCreatedEvent(@NotNull BookID id) implements DomainEvent {
}
