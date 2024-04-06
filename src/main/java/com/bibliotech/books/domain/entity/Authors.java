package com.bibliotech.books.domain.entity;

import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

public record Authors(@NotEmpty Set<Author> value) implements ValueObject<Set<Author>> {
}
