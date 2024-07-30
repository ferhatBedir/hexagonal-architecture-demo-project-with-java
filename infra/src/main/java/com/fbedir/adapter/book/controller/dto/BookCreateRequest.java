package com.fbedir.adapter.book.controller.dto;

import com.fbedir.book.usecase.BookCreateUseCase;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateRequest {

    @NotBlank(message = "invalid.book.name")
    private String name;

    @Min(value = 0, message = "invalid.quantity.value")
    private Integer quantity;

    @Min(value = 1, message = "invalid.author.id")
    private Long authorId;

    public BookCreateUseCase toUseCase() {
        return new BookCreateUseCase(getName(), getQuantity(), getAuthorId());

    }

}
