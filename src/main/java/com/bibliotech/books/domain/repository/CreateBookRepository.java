package com.bibliotech.books.domain.repository;

import com.bibliotech.books.domain.entity.Book;

public interface CreateBookRepository {

    void create(Book book);
}
