package com.bibliotech.books.domain.entity;

import jakarta.validation.constraints.NotBlank;

public record Author(@NotBlank String value) implements ValueObject<String> {
}
