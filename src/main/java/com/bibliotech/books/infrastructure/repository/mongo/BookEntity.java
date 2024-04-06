package com.bibliotech.books.infrastructure.repository.mongo;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@MongoEntity(collection = "books")
public class BookEntity extends PanacheMongoEntityBase {

    @BsonId
    private UUID id;

    private String title;

    private Set<String> authors;

    @BsonProperty("_metadata")
    private MetadataEntity metadata;
}
