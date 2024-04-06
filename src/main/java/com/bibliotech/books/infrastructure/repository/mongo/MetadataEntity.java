package com.bibliotech.books.infrastructure.repository.mongo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MetadataEntity {

    private String createdBy;
    private LocalDateTime createdAt;
    private String modifiedBy;
    private LocalDateTime modifiedAt;
    private String deletedBy;
    private LocalDateTime deletedAt;
}
