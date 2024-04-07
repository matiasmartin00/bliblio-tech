package com.bibliotech.books.domain.command;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DeleteBookCommand(@NotNull UUID id) implements Command{
}
