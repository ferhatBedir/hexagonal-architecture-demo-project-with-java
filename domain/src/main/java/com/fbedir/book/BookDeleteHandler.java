package com.fbedir.book;

import com.fbedir.book.port.BookDataPort;
import com.fbedir.book.usecase.BookDeleteUseCase;
import com.fbedir.common.DomainComponent;
import com.fbedir.common.usecase.UseCaseVoidHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class BookDeleteHandler implements UseCaseVoidHandler<BookDeleteUseCase> {

    private final BookDataPort bookDataPort;

    @Override
    public void handle(BookDeleteUseCase useCase) {
        bookDataPort.deleteBook(useCase.id());
        log.info("Book deleted: {}", useCase.id());

    }

}
