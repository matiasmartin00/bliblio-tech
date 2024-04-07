package com.bibliotech.books.domain.query;

import com.bibliotech.books.domain.projection.PaginatedBook;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record FindAllQuery(@NotNull @Min(0) Integer offset, @NotNull @Min(1) @Max(100) Integer limit) implements Query<PaginatedBook> {
}
