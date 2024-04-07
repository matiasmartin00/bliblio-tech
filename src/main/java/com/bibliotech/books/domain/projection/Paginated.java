package com.bibliotech.books.domain.projection;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record Paginated(@NotNull @Min(0) Long total, @NotNull @Min(0) Integer offset, @NotNull @Min(1) @Max(100) Integer limit) {
}
