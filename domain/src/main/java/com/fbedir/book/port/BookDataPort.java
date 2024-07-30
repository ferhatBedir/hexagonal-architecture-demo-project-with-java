package com.fbedir.book.port;

import com.fbedir.book.model.Book;
import com.fbedir.book.usecase.BookCreateUseCase;
import com.fbedir.book.usecase.BookUpdateUseCase;

public interface BookDataPort {

    void create(BookCreateUseCase useCase);

    Book update(BookUpdateUseCase useCase);

    void deleteBook(Long id);

    Book lendBook(Long id);

}
