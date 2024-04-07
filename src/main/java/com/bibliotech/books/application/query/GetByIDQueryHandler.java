package com.bibliotech.books.application.query;

import com.bibliotech.books.domain.entity.Book;
import com.bibliotech.books.domain.query.GetByIDQuery;
import com.bibliotech.books.domain.query.QueryHandler;
import com.bibliotech.books.domain.usecase.GetBookByIDUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class GetByIDQueryHandler implements QueryHandler<GetByIDQuery, Book> {

    private final GetBookByIDUseCase getBookByIDUseCase;

    @Override
    public Book ask(GetByIDQuery query) {
        return getBookByIDUseCase.getByID(query);
    }
}
