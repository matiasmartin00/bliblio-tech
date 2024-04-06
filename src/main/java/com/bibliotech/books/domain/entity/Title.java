package com.bibliotech.books.domain.entity;

import jakarta.validation.constraints.NotBlank;

public record Title(@NotBlank String value) implements ValueObject<String> {
}
