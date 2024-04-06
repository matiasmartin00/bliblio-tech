package com.bibliotech.books.domain.entity.metadata;

import com.bibliotech.books.domain.entity.ValueObject;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ModifiedAt(@NotNull LocalDateTime value) implements ValueObject<LocalDateTime> {
}