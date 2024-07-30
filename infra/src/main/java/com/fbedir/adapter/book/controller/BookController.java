package com.fbedir.adapter.book.controller;

import com.fbedir.adapter.book.controller.dto.BookCreateRequest;
import com.fbedir.adapter.book.controller.dto.BookUpdateRequest;
import com.fbedir.book.model.Book;
import com.fbedir.book.usecase.BookCreateUseCase;
import com.fbedir.book.usecase.BookDeleteUseCase;
import com.fbedir.book.usecase.BookLendUseCase;
import com.fbedir.book.usecase.BookUpdateUseCase;
import com.fbedir.common.usecase.UseCaseHandler;
import com.fbedir.common.usecase.UseCaseVoidHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/book")
public class BookController {

    private final UseCaseVoidHandler<BookCreateUseCase> bookCreateUseCaseHandler;

    private final UseCaseVoidHandler<BookDeleteUseCase> bookDeleteUseCaseHandler;

    private final UseCaseHandler<Book, BookLendUseCase> bookLendUseCaseHandler;

    private final UseCaseHandler<Book, BookUpdateUseCase> bookUpdateUseCaseHandler;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@Valid @RequestBody BookCreateRequest bookCreateRequest) {
        bookCreateUseCaseHandler.handle(bookCreateRequest.toUseCase());
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable(value = "id") Long id) {
        bookDeleteUseCaseHandler.handle(new BookDeleteUseCase(id));
        return ResponseEntity.ok().build();

    }

    @GetMapping("/lend/{id}")
    public ResponseEntity<Object> lend(@Valid @PathVariable(value = "id") Long id) {
        Book book = bookLendUseCaseHandler.handle(new BookLendUseCase(id));
        return ResponseEntity.ok(book);

    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest) {
        Book book = bookUpdateUseCaseHandler.handle(bookUpdateRequest.toUseCase());
        return ResponseEntity.ok(book);

    }

}
