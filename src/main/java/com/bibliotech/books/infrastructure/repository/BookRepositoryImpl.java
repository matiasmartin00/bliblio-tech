package com.bibliotech.books.infrastructure.repository;

import com.bibliotech.books.domain.entity.Book;
import com.bibliotech.books.domain.entity.BookID;
import com.bibliotech.books.domain.projection.PaginatedBook;
import com.bibliotech.books.domain.repository.*;
import com.bibliotech.books.infrastructure.repository.mapper.BookMapper;
import com.bibliotech.books.infrastructure.repository.mongo.BookEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepositoryImpl implements CreateBookRepository, UpdateBookRepository, DeleteBookRepository, GetBookByIDRepository, ExistsBookByIDRepository, FindAllBookRepository {

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

    @Override
    public boolean exists(BookID id) {
        return BookEntity.count("id", id.value()) > 0;
    }

    @Override
    public PaginatedBook findAll(Integer offset, Integer limit) {
        List<BookEntity> data = BookEntity.findAll().range(offset, (offset + limit - 1)).list();
        var count = BookEntity.count();

        return BookMapper.mapPaginated(data, offset, limit, count);
    }
}
