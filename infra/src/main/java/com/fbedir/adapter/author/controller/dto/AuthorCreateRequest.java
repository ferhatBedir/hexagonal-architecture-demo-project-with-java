package com.fbedir.adapter.author.controller.dto;

import com.fbedir.author.usecase.AuthorCreateUseCase;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorCreateRequest {

    @NotBlank(message = "invalid.author.name")
    private String name;

    @NotBlank(message = "invalid.author.surname")
    private String surname;

    public AuthorCreateUseCase toUseCase() {
        return new AuthorCreateUseCase(getName(), getSurname());

    }

}
