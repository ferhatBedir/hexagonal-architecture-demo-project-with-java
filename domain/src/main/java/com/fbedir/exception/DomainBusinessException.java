package com.fbedir.exception;

import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class DomainBusinessException extends RuntimeException implements Supplier<DomainBusinessException> {

    private final ErrorEnum error;

    private final String[] args;

    public DomainBusinessException(ErrorEnum error, String... args) {
        this.error = error;
        this.args = args;
    }

    @Override
    public DomainBusinessException get() {
        return this;
    }

}
