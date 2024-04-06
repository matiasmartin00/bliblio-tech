package com.bibliotech.books.infrastructure.repository.mapper;

import com.bibliotech.books.domain.entity.Author;
import com.bibliotech.books.domain.entity.Authors;
import com.bibliotech.books.domain.entity.Book;
import com.bibliotech.books.domain.entity.ValueObject;
import com.bibliotech.books.domain.entity.metadata.Metadata;
import com.bibliotech.books.infrastructure.repository.mongo.BookEntity;
import com.bibliotech.books.infrastructure.repository.mongo.MetadataEntity;

import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class BookMapper {

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
                .modifiedAt(map(metadata.deletedAt()))
                .build();
    }

    private static <T> T map(ValueObject<T> src) {
        if (isNull(src)) {
            return null;
        }
        return src.value();
    }
}
