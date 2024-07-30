package com.fbedir.common.usecase;

import com.fbedir.common.model.UseCase;

public interface UseCaseVoidHandler<T extends UseCase> {

    void handle(T useCase);

}
