package com.korailtalk.server.api.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorStatus {

    // 400 : Bad Request
    TEST(HttpStatus.BAD_REQUEST, "test");
    // 401 : Unauthorized

    // 404 : Not Found

    private final HttpStatus httpStatus;

    private final String message;
}