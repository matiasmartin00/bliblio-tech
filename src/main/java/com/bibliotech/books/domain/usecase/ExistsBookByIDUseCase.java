package com.bibliotech.books.domain.usecase;

import com.bibliotech.books.domain.query.ExistsByIDQuery;

public interface ExistsBookByIDUseCase {

    void exists(ExistsByIDQuery query);
}
