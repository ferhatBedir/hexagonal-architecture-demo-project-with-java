package com.fbedir.book;

import com.fbedir.book.model.Book;
import com.fbedir.book.port.BookDataPort;
import com.fbedir.book.usecase.BookUpdateUseCase;
import com.fbedir.common.DomainComponent;
import com.fbedir.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class BookUpdateHandler implements UseCaseHandler<Book, BookUpdateUseCase> {

    private final BookDataPort bookDataPort;

    @Override
    public Book handle(BookUpdateUseCase useCase) {
        return bookDataPort.update(useCase);

    }


}
