package com.bibliotech.books.domain.entity.metadata;

import com.bibliotech.books.domain.entity.ValueObject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreatedBy(@NotBlank String value) implements ValueObject<String> {
}
