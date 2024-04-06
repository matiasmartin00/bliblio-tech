package com.bibliotech.books.domain.repository;

import com.bibliotech.books.domain.entity.Book;

public interface DeleteBookRepository {

    void delete(Book book);
}
