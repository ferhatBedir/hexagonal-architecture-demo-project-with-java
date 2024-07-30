package com.fbedir.author;

import com.fbedir.author.port.AuthorDataPort;
import com.fbedir.author.usecase.AuthorCreateUseCase;
import com.fbedir.common.DomainComponent;
import com.fbedir.common.usecase.UseCaseVoidHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class AuthorCreateHandler implements UseCaseVoidHandler<AuthorCreateUseCase> {

    private final AuthorDataPort authorDataPort;

    @Override
    public void handle(AuthorCreateUseCase useCase) {
        authorDataPort.createNewAuthor(useCase);
    }

}
