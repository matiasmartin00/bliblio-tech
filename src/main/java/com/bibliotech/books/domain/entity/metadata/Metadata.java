package com.bibliotech.books.domain.entity.metadata;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder(toBuilder = true)
public record Metadata(
        @NotNull CreatedBy createdBy,
        @NotNull CreatedAt createdAt,
        ModifiedBy modifiedBy,
        ModifiedAt modifiedAt,
        DeletedBy deletedBy,
        DeletedAt deletedAt
) {
}
