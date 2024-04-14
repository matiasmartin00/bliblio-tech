package com.bibliotech.books.domain.event;

import com.bibliotech.books.domain.entity.BookID;
import jakarta.validation.constraints.NotNull;

public record BookUpdatedEvent(@NotNull BookID id) implements DomainEvent {
}
