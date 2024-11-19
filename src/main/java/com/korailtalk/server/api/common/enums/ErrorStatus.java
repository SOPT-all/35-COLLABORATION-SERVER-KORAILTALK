package com.korailtalk.server.api.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorStatus {

    // 400 : Bad Request

    // 401 : Unauthorized

    // 404 : Not Found
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "아이디에 해당하는 유저를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;

    private final String message;
}
