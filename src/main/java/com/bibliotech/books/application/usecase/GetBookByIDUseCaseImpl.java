package com.bibliotech.books.application.usecase;

import com.bibliotech.books.domain.entity.Book;
import com.bibliotech.books.domain.entity.BookID;
import com.bibliotech.books.domain.query.GetByIDQuery;
import com.bibliotech.books.domain.repository.GetBookByIDRepository;
import com.bibliotech.books.domain.usecase.GetBookByIDUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class GetBookByIDUseCaseImpl implements GetBookByIDUseCase {

    private final GetBookByIDRepository getBookByIDRepository;

    @Override
    public Book getByID(GetByIDQuery query) {
        var bookID = new BookID(query.id());
        return getBookByIDRepository.getByID(bookID)
                .orElseThrow(() -> new RuntimeException("Book ID not found"));
    }
}
