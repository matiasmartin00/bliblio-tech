package com.bibliotech.books.application.query;

import com.bibliotech.books.domain.projection.PaginatedBook;
import com.bibliotech.books.domain.query.FindAllQuery;
import com.bibliotech.books.domain.query.QueryHandler;
import com.bibliotech.books.domain.usecase.FindAllBookUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class FindAllQueryHandler implements QueryHandler<FindAllQuery, PaginatedBook> {

    private final FindAllBookUseCase findAllBookUseCase;

    @Override
    public PaginatedBook ask(FindAllQuery query) {
        return findAllBookUseCase.findAll(query);
    }
}
