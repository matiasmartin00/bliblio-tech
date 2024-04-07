package com.bibliotech.books.domain.query;

import com.bibliotech.books.domain.entity.Book;
import com.bibliotech.books.domain.entity.BookID;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record GetByIDQuery(@NotNull UUID id) implements Query<Book> {
}
