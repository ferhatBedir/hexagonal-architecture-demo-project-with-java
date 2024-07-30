package com.fbedir.book;

import com.fbedir.book.port.BookDataPort;
import com.fbedir.book.usecase.BookCreateUseCase;
import com.fbedir.common.DomainComponent;
import com.fbedir.common.usecase.UseCaseVoidHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class BookCreateHandler implements UseCaseVoidHandler<BookCreateUseCase> {

    private final BookDataPort bookDataPort;

    @Override
    public void handle(BookCreateUseCase useCase) {
        bookDataPort.create(useCase);
        log.info("Book created");

    }


}
