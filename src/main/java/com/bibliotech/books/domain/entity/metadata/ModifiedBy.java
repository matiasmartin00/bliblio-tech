package com.bibliotech.books.domain.entity.metadata;

import com.bibliotech.books.domain.entity.ValueObject;
import jakarta.validation.constraints.NotBlank;

public record ModifiedBy(@NotBlank String value) implements ValueObject<String> {
}
