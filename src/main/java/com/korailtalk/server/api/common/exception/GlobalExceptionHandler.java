package com.korailtalk.server.api.common.exception;

import com.korailtalk.server.api.common.dto.APIErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BadRequestException.class, NotFoundException.class, UnAuthorizedException.class})
    public ResponseEntity<APIErrorResponse> handleCustomException(final KorailException korailException) {
        return APIErrorResponse.of(korailException.getHttpStatus(), korailException.getMessage());
    }
}
