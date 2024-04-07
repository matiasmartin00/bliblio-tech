package com.bibliotech.books.domain.query;

import com.bibliotech.books.domain.entity.Book;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ExistsByIDQuery(@NotNull UUID id) implements Query<Book> {
}
