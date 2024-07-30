package com.fbedir.author.port;

import com.fbedir.author.usecase.AuthorCreateUseCase;

public interface AuthorDataPort {

    void createNewAuthor(AuthorCreateUseCase useCase);

}
