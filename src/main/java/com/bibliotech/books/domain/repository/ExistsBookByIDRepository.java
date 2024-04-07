package com.bibliotech.books.domain.repository;

import com.bibliotech.books.domain.entity.BookID;
import jakarta.validation.constraints.NotNull;

public interface ExistsBookByIDRepository {

    boolean exists(@NotNull BookID id);
}
