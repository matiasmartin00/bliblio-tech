package com.bibliotech.books.domain.usecase;

import com.bibliotech.books.domain.entity.Book;
import com.bibliotech.books.domain.query.GetByIDQuery;

import java.util.UUID;

public interface GetBookByIDUseCase {

    Book getByID(GetByIDQuery query);
}
