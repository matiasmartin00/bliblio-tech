package com.bibliotech.books.application.usecase;

import com.bibliotech.books.domain.command.DeleteBookCommand;
import com.bibliotech.books.domain.query.ExistsByIDQuery;
import com.bibliotech.books.domain.query.GetByIDQuery;
import com.bibliotech.books.domain.repository.DeleteBookRepository;
import com.bibliotech.books.domain.usecase.DeleteBookUseCase;
import com.bibliotech.books.domain.usecase.ExistsBookByIDUseCase;
import com.bibliotech.books.domain.usecase.GetBookByIDUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class DeleteBookUseCaseImpl implements DeleteBookUseCase {

    private final ExistsBookByIDUseCase existsBookByIDUseCase;
    private final GetBookByIDUseCase getBookByIDUseCase;
    private final DeleteBookRepository deleteBookRepository;

    @Override
    public void delete(DeleteBookCommand command) {
        var queryExists = new ExistsByIDQuery(command.id());
        existsBookByIDUseCase.exists(queryExists);

        var getByIDQuery = new GetByIDQuery(command.id());
        var book = getBookByIDUseCase.getByID(getByIDQuery);
        book.delete();
        deleteBookRepository.delete(book);
    }
}
