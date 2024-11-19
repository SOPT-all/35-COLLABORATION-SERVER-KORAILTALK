package com.korailtalk.server.api.common.exception;

import com.korailtalk.server.api.common.enums.ErrorStatus;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class KorailException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String message;

    public KorailException(final ErrorStatus errorStatus) {
        super(errorStatus.getMessage());
        this.httpStatus = errorStatus.getHttpStatus();
        this.message = errorStatus.getMessage();
    }
}
