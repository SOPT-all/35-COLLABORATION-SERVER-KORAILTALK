package com.korailtalk.server.api.common.exception;

import com.korailtalk.server.api.common.enums.ErrorStatus;

public class BadRequestException extends KorailException {
    public BadRequestException(final ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
