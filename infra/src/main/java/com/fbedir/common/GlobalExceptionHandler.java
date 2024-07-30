package com.fbedir.common;

import com.fbedir.exception.ErrorDetail;
import com.fbedir.exception.ErrorModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Locale;

import static com.fbedir.exception.ErrorEnum.UNEXPECTED_ERROR;
import static com.fbedir.exception.ErrorEnum.VALIDATION_ERROR;
import static java.lang.Boolean.FALSE;
import static java.util.Objects.nonNull;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorModel> handle(Exception exception) {
        log.error("Exception occurred.", exception.getCause());
        var message = messageSource.getMessage(UNEXPECTED_ERROR.getMessageKey(), null, UNEXPECTED_ERROR.getMessageKey(), Locale.ENGLISH);
        var response = prepareResponseModel(UNEXPECTED_ERROR.getCode(), message, exception);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorModel> handle(MethodArgumentNotValidException exception) {
        log.info("MethodArgumentNotValidException occurred.", exception.getCause());

        var messageKey = getMessageKey(exception);
        String message;
        if (nonNull(messageKey)) {
            message = messageSource.getMessage(messageKey, null, messageKey, Locale.ENGLISH);
        } else {
            message = "Please check request model.";
        }

        var response = prepareResponseModel(VALIDATION_ERROR.getCode(), message, exception);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    private ErrorModel prepareResponseModel(String errorCode, String message, Exception exception) {
        var detail = new ErrorDetail(errorCode, message);
        return new ErrorModel(detail, exception.getClass().getSimpleName(), LocalDateTime.now());

    }

    private String getMessageKey(MethodArgumentNotValidException exception) {
        var exceptionBindingResult = exception.getBindingResult();
        var errors = exceptionBindingResult.getAllErrors();

        if (FALSE.equals(errors.isEmpty())) {
            final var firstError = errors.getFirst();
            return firstError.getDefaultMessage();

        }

        return null;

    }

}
