package com.bibliotech.books.apirest;

import com.bibliotech.books.apirest.dto.BookDTO;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Path("/books")
@RequiredArgsConstructor
public class BookController {

    private final Map<UUID, BookDTO> books = new HashMap<>();

    @GET
    public Response findAll() {
        return Response.ok(books.values())
                .build();
    }

    @POST
    public Response create(@Valid BookDTO book) {

        if (books.containsKey(book.id())) {
            return Response
                    .status(409)
                    .build();
        }

        books.put(book.id(), book);

        return Response
                .created(null)
                .build();
    }

    @PUT
    public Response update(@Valid BookDTO book) {
        if (!books.containsKey(book.id())) {
            return Response
                    .status(404)
                    .build();
        }

        books.put(book.id(), book);

        return Response
                .noContent()
                .build();
    }

    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id") UUID id) {
        if (!books.containsKey(id)) {
            return Response
                    .status(404)
                    .build();
        }

        books.remove(id);

        return Response
                .noContent()
                .build();
    }

    @Path("/{id}")
    @GET
    public Response getById(@PathParam("id") UUID id) {
        if (!books.containsKey(id)) {
            return Response
                    .status(404)
                    .build();
        }
        return Response
                .ok(books.get(id))
                .build();
    }
}
