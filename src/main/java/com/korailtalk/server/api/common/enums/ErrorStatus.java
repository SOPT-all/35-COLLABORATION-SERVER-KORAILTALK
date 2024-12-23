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
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "아이디에 해당하는 유저를 찾을 수 없습니다."),
    NOT_FOUND_TICKET(HttpStatus.NOT_FOUND, "아이디에 해당하는 티켓을 찾을 수 없습니다."),
    NOT_FOUND_TRAIN(HttpStatus.NOT_FOUND, "시간표에 해당하는 열차를 찾을 수 없습니다."),
    NOT_FOUND_TIMETABLE(HttpStatus.NOT_FOUND, "아이디에 해당하는 시간표를 찾을 수 없습니다."),
    NOT_FOUND_SEAT(HttpStatus.NOT_FOUND, "아이디에 해당하는 좌석을 찾을 수 없습니다");

    private final HttpStatus httpStatus;

    private final String message;
}
