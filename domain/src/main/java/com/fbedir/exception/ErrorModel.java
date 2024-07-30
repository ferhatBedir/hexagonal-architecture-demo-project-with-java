package com.fbedir.exception;

import java.time.LocalDateTime;

public record ErrorModel(ErrorDetail detail, String exception, LocalDateTime occurredAt) {

}
