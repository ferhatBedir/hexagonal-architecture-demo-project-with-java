package com.fbedir.common.usecase;

import com.fbedir.common.model.UseCase;

public interface UseCaseHandler<E, T extends UseCase> {

    E handle(T useCase);

}
