package com.bibliotech.books.domain.entity;

import com.bibliotech.books.domain.entity.metadata.Metadata;
import lombok.*;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AggregateRoot<ID> {

    private final ID id;
    protected Metadata metadata;
}
