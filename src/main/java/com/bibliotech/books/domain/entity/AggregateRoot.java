package com.bibliotech.books.domain.entity;

import lombok.*;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AggregateRoot<ID> {

    private final ID id;
}
