package com.fbedir.author.usecase;

import com.fbedir.common.model.UseCase;

public record AuthorCreateUseCase(String name, String surname) implements UseCase {

}
