package com.bibliotech.books.domain.entity.metadata;

import com.bibliotech.books.domain.entity.ValueObject;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DeletedAt(@NotNull LocalDateTime value) implements ValueObject<LocalDateTime> {
}
