package com.fbedir.adapter.author.controller;

import com.fbedir.adapter.author.controller.dto.AuthorCreateRequest;
import com.fbedir.author.usecase.AuthorCreateUseCase;
import com.fbedir.common.usecase.UseCaseVoidHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/author")
public class AuthorController {

    private final UseCaseVoidHandler<AuthorCreateUseCase> authorCreateUseCaseHandler;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@Valid @RequestBody AuthorCreateRequest authorCreateRequest) {
        authorCreateUseCaseHandler.handle(authorCreateRequest.toUseCase());
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}
