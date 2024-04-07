package com.bibliotech.books.domain.usecase;

import com.bibliotech.books.domain.projection.PaginatedBook;
import com.bibliotech.books.domain.query.FindAllQuery;

public interface FindAllBookUseCase {

    PaginatedBook findAll(FindAllQuery query);
}
