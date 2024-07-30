package com.fbedir.exception;

public record ErrorDetail(String code, String message) {

    public static final String CODE_PREFIX = "book_management";

}
