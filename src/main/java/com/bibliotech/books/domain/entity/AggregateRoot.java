package com.bibliotech.books.domain.entity;

import com.bibliotech.books.domain.entity.metadata.Metadata;
import com.bibliotech.books.domain.event.DomainEvent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public abstract class AggregateRoot<ID> {

    private final ID id;
    protected Metadata metadata;
    private List<DomainEvent> domainEvents;

    protected AggregateRoot(ID id, Metadata metadata) {
        this.id = id;
        this.metadata = metadata;
        this.domainEvents = new ArrayList<>();
    }

    protected void addEvent(@NotNull DomainEvent event) {
        domainEvents.add(event);
    }
}
