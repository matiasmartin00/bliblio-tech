package com.bibliotech.books.domain.query;

import java.lang.reflect.ParameterizedType;

public interface QueryHandler<Q extends Query<R>, R> {

    R ask(Q query);

    default Class<Q> listenTo() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericInterfaces()[0];
        return (Class<Q>) genericSuperclass.getActualTypeArguments()[0];
    }
}
