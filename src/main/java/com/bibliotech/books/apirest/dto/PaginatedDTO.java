package com.bibliotech.books.apirest.dto;

public record PaginatedDTO(Long total, Integer offset, Integer limit) {
}
