package com.bibliotech.books.apirest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;
import java.util.UUID;

public record UpdateBookDTO(
        @NotBlank String title,
        @NotEmpty Set<String> authors) {
}
