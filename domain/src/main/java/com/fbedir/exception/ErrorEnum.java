package com.fbedir.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.fbedir.exception.ErrorDetail.CODE_PREFIX;

@Getter
@RequiredArgsConstructor
public enum ErrorEnum {

    VALIDATION_ERROR(CODE_PREFIX.concat("400"), "validation.error"),
    UNEXPECTED_ERROR(CODE_PREFIX.concat("-500"), "unexpected.error.message");

    private final String code;

    private final String messageKey;

}
