package com.bibliotech.books.domain.entity;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record BookID(@NotNull UUID value) implements ValueObject<UUID> {
}
