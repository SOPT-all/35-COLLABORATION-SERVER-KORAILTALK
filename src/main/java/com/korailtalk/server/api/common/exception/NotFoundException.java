package com.korailtalk.server.api.common.exception;

import com.korailtalk.server.api.common.enums.ErrorStatus;

public class NotFoundException extends KorailException {

    public NotFoundException(final ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
