package com.bibliotech.books.application.usecase;

import com.bibliotech.books.domain.entity.BookID;
import com.bibliotech.books.domain.query.ExistsByIDQuery;
import com.bibliotech.books.domain.repository.ExistsBookByIDRepository;
import com.bibliotech.books.domain.usecase.ExistsBookByIDUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class ExistsBookByIDUseCaseImpl implements ExistsBookByIDUseCase {

    private final ExistsBookByIDRepository existsBookByIDRepository;

    @Override
    public void exists(ExistsByIDQuery query) {
        var id = new BookID(query.id());
        if (existsBookByIDRepository.exists(id)) {
            throw new RuntimeException("Book doesn't exists");
        }
    }
}
