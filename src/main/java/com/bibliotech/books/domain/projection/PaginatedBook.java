package com.bibliotech.books.domain.projection;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PaginatedBook(@NotNull List<ProjectionBook> data, @NotNull Paginated metadata) {
}
