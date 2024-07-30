package com.fbedir.adapter.author;

import com.fbedir.adapter.author.entity.AuthorEntity;
import com.fbedir.adapter.author.repository.AuthorRepository;
import com.fbedir.author.port.AuthorDataPort;
import com.fbedir.author.usecase.AuthorCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthorDataAdapter implements AuthorDataPort {

    private final AuthorRepository repository;

    @Override
    public void createNewAuthor(AuthorCreateUseCase useCase) {
        //@formatter:off
        var newAuthor = AuthorEntity.builder()
                                    .createdAt(LocalDateTime.now())
                                    .name(useCase.name())
                                    .surname(useCase.surname())
                                    .build();
        //@formatter:on
        repository.save(newAuthor);
    }

}
