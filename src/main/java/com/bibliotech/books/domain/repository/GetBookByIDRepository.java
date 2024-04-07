package com.bibliotech.books.domain.repository;

import com.bibliotech.books.domain.entity.Book;
import com.bibliotech.books.domain.entity.BookID;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public interface GetBookByIDRepository {

    Optional<Book> getByID(@NotNull BookID id);
}
