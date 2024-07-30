package com.fbedir.book;

import com.fbedir.book.model.Book;
import com.fbedir.book.port.BookDataPort;
import com.fbedir.book.usecase.BookLendUseCase;
import com.fbedir.common.DomainComponent;
import com.fbedir.common.usecase.UseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class BookLendHandler implements UseCaseHandler<Book, BookLendUseCase> {

    private final BookDataPort bookDataPort;

    @Override
    public Book handle(BookLendUseCase useCase) {
        return bookDataPort.lendBook(useCase.id());

    }

}
