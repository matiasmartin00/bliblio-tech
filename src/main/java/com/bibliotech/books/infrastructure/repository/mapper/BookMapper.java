package com.bibliotech.books.infrastructure.repository.mapper;

import com.bibliotech.books.domain.entity.*;
import com.bibliotech.books.domain.entity.metadata.*;
import com.bibliotech.books.infrastructure.repository.mongo.BookEntity;
import com.bibliotech.books.infrastructure.repository.mongo.MetadataEntity;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class BookMapper {

    public static Book map(BookEntity src) {
        return Book.builder()
                .bookID(map(src.getId()))
                .title(map(src.getTitle()))
                .authors(map(src.getAuthors()))
                .metadata(map(src.getMetadata()))
                .build();
    }

    private static BookID map(UUID src) {
        return new BookID(src);
    }

    private static Metadata map(MetadataEntity src) {
        return Metadata.builder()
                .createdAt(new CreatedAt(src.getCreatedAt()))
                .createdBy(new CreatedBy(src.getCreatedBy()))
                .modifiedAt(new ModifiedAt(src.getModifiedAt()))
                .modifiedBy(new ModifiedBy(src.getModifiedBy()))
                .deletedAt(new DeletedAt(src.getDeletedAt()))
                .deletedBy(new DeletedBy(src.getDeletedBy()))
                .build();
    }

    private static Authors map(Set<String> src) {
        var authors = src.stream()
                .map(Author::new)
                .collect(Collectors.toSet());
        return new Authors(authors);
    }

    private static Title map(String src) {
        return new Title(src);
    }

    public static BookEntity map(Book src) {
        return BookEntity.builder()
                .id(map(src.getId()))
                .title(map(src.getTitle()))
                .metadata(map(src.getMetadata()))
                .authors(map(src.getAuthors()))
                .build();
    }

    private static Set<String> map(Authors src) {
        return src.value()
                .stream()
                .map(BookMapper::map)
                .collect(Collectors.toSet());
    }

    private static MetadataEntity map(Metadata metadata) {
        return MetadataEntity.builder()
                .createdAt(map(metadata.createdAt()))
                .createdBy(map(metadata.createdBy()))
                .modifiedAt(map(metadata.modifiedAt()))
                .modifiedBy(map(metadata.modifiedBy()))
                .deletedAt(map(metadata.deletedAt()))
                .deletedBy(map(metadata.deletedBy()))
                .build();
    }

    private static <T> T map(ValueObject<T> src) {
        if (isNull(src)) {
            return null;
        }
        return src.value();
    }
}
