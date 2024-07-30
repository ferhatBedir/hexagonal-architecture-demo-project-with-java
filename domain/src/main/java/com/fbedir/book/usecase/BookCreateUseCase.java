package com.fbedir.book.usecase;

import com.fbedir.common.model.UseCase;

public record BookCreateUseCase(String name, Integer quantity, Long authorId) implements UseCase {

}
