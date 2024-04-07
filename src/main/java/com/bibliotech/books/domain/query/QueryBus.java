package com.bibliotech.books.domain.query;

public interface QueryBus {

    <R> R ask(Query<R> query);
}
