package com.bibliotech.books.apirest;

import com.arjuna.ats.jta.exceptions.NotImplementedException;
import com.bibliotech.books.apirest.dto.BookDTO;
import com.bibliotech.books.apirest.dto.CreateBookDTO;
import com.bibliotech.books.apirest.dto.UpdateBookDTO;
import com.bibliotech.books.apirest.mapper.BookMapper;
import com.bibliotech.books.domain.command.CommandBus;
import com.bibliotech.books.domain.query.QueryBus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Path("/books")
@RequiredArgsConstructor
public class BookController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @GET
    public Response findAll() {
        return Response.status(501).build();
    }

    @POST
    public Response create(@Valid CreateBookDTO book) {
        final var command = BookMapper.map(book);
        commandBus.execute(command);
        return Response
                .created(null)
                .build();
    }

    @Path("/{id}")
    @PUT
    public Response update(@NotNull @PathParam("id") UUID id, @Valid UpdateBookDTO book) {
        var command = BookMapper.map(id, book);
        commandBus.execute(command);
        return Response
                .noContent()
                .build();
    }

    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id") UUID id) {
        var command = BookMapper.mapCommand(id);
        commandBus.execute(command);
        return Response
                .noContent()
                .build();
    }

    @Path("/{id}")
    @GET
    public Response getById(@PathParam("id") UUID id) {
        var bookId = BookMapper.mapQuery(id);
        var book = queryBus.ask(bookId);
        return Response
                .ok(BookMapper.map(book))
                .build();
    }
}
