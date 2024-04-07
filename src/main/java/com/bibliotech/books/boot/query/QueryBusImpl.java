package com.bibliotech.books.boot.query;

import com.bibliotech.books.domain.query.Query;
import com.bibliotech.books.domain.query.QueryBus;
import com.bibliotech.books.domain.query.QueryHandler;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Dependent
public class QueryBusImpl<Q extends Query<R>, R> implements QueryBus {

    private final Map<Class<Q>, QueryHandler<Q, R>> queryHandlers;

    @Inject
    public QueryBusImpl(@Any Instance<QueryHandler<? extends Query<?>, ?>> queryHandlers) {
        Map<Class<Q>, QueryHandler<Q, R>> temp = new HashMap<>();
        queryHandlers.forEach(handler -> {
            temp.put((Class<Q>) handler.listenTo(), (QueryHandler<Q, R>) handler);
        });
        this.queryHandlers = Collections.unmodifiableMap(temp);
    }

    @Override
    public <R> R ask(Query<R> query) {
        var handler = Optional.ofNullable(queryHandlers.get(query.getClass()))
                .orElseThrow(() -> new RuntimeException("Query can't be handler " + query.getClass().getSimpleName()));
        return (R) handler.ask((Q) query);
    }
}
