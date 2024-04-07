package com.bibliotech.books.apirest.dto;

import java.util.List;

public record PaginatedBookDTO (List<BookDTO> data, PaginatedDTO metadata) {
}
