package com.bibliotech.books.domain.projection;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.UUID;

public record ProjectionBook(@NotNull UUID id, @NotBlank String title, @NotEmpty Set<String> authors) {
}
