package com.bibliotech.books.domain.repository;

import com.bibliotech.books.domain.projection.PaginatedBook;
import jakarta.validation.constraints.NotNull;

public interface FindAllBookRepository {

    PaginatedBook findAll(@NotNull Integer offset, @NotNull Integer limit);
}
