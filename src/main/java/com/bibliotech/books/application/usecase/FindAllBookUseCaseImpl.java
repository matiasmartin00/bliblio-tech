package com.bibliotech.books.application.usecase;

import com.bibliotech.books.domain.projection.PaginatedBook;
import com.bibliotech.books.domain.query.FindAllQuery;
import com.bibliotech.books.domain.repository.FindAllBookRepository;
import com.bibliotech.books.domain.usecase.FindAllBookUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class FindAllBookUseCaseImpl implements FindAllBookUseCase {

    private final FindAllBookRepository findAllBookRepository;
    @Override
    public PaginatedBook findAll(FindAllQuery query) {
        return findAllBookRepository.findAll(query.offset(), query.limit());
    }
}
