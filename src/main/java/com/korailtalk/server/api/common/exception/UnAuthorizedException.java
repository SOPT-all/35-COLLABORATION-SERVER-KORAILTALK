package com.korailtalk.server.api.common.exception;

import com.korailtalk.server.api.common.enums.ErrorStatus;

public class UnAuthorizedException extends KorailException {

    public UnAuthorizedException(final ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
