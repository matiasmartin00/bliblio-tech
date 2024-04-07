package com.bibliotech.books.apirest.mapper;

import com.bibliotech.books.apirest.dto.*;
import com.bibliotech.books.domain.command.CreateBookCommand;
import com.bibliotech.books.domain.command.DeleteBookCommand;
import com.bibliotech.books.domain.command.UpdateBookCommand;
import com.bibliotech.books.domain.entity.Authors;
import com.bibliotech.books.domain.entity.Book;
import com.bibliotech.books.domain.entity.ValueObject;
import com.bibliotech.books.domain.projection.Paginated;
import com.bibliotech.books.domain.projection.PaginatedBook;
import com.bibliotech.books.domain.projection.ProjectionBook;
import com.bibliotech.books.domain.query.FindAllQuery;
import com.bibliotech.books.domain.query.GetByIDQuery;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class BookMapper {

    public static CreateBookCommand map(CreateBookDTO dto) {
        return new CreateBookCommand(
                dto.id(),
                dto.title(),
                dto.authors()
        );
    }

    public static UpdateBookCommand map(UUID id, UpdateBookDTO dto) {
        return new UpdateBookCommand(
                id,
                dto.title(),
                dto.authors()
        );
    }

    public static DeleteBookCommand mapCommand(UUID id) {
        return new DeleteBookCommand(id);
    }

    public static GetByIDQuery mapQuery(UUID id) {
        return new GetByIDQuery(id);
    }

    public static PaginatedBookDTO map(PaginatedBook src) {
        return new PaginatedBookDTO(
                mapList(src.data()),
                map(src.metadata())
        );
    }

    private static PaginatedDTO map(Paginated src) {
        return new PaginatedDTO(src.total(), src.offset(), src.limit());
    }

    private static List<BookDTO> mapList(List<ProjectionBook> src) {
        return src.stream()
                .map(BookMapper::map)
                .collect(Collectors.toList());
    }

    private static BookDTO map(ProjectionBook src) {
        return new BookDTO(src.id(), src.title(), src.authors());
    }

    public static FindAllQuery mapQuery(Integer offset, Integer limit) {
        return new FindAllQuery(offset, limit);
    }

    public static BookDTO map(Book src) {
        return new BookDTO(
                map(src.getId()),
                map(src.getTitle()),
                map(src.getAuthors())
        );
    }

    private static Set<String> map(Authors src) {
        return src.value()
                .stream()
                .map(BookMapper::map)
                .collect(Collectors.toSet());
    }

    private static <R> R map(ValueObject<R> val) {
        if (isNull(val)) {
            return null;
        }

        return val.value();
    }
}
