package com.bibliotech.books.infrastructure.repository;

import com.bibliotech.books.domain.entity.Book;
import com.bibliotech.books.domain.entity.BookID;
import com.bibliotech.books.domain.repository.CreateBookRepository;
import com.bibliotech.books.domain.repository.DeleteBookRepository;
import com.bibliotech.books.domain.repository.GetBookByIDRepository;
import com.bibliotech.books.domain.repository.UpdateBookRepository;
import com.bibliotech.books.infrastructure.repository.mapper.BookMapper;
import com.bibliotech.books.infrastructure.repository.mongo.BookEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class BookRepositoryImpl implements CreateBookRepository, UpdateBookRepository, DeleteBookRepository, GetBookByIDRepository {

    @Override
    public void create(Book book) {
        var entity = BookMapper.map(book);
        entity.persist();
    }

    @Override
    public void delete(Book book) {
        var entity = BookMapper.map(book);
        entity.update();
    }

    @Override
    public void update(Book book) {
        var entity = BookMapper.map(book);
        entity.update();
    }

    @Override
    public Optional<Book> getByID(BookID id) {
        Optional<BookEntity> entity = BookEntity.findByIdOptional(id.value());
        return entity
                .map(BookMapper::map);
    }
}
