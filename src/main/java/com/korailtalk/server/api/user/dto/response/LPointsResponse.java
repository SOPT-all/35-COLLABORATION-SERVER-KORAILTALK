package com.korailtalk.server.api.user.dto.response;

public record LPointsResponse(
        boolean isValid,
        int point
) {

    public static LPointsResponse of(final boolean isValid, final int point) {
        return new LPointsResponse(isValid, point);
    }
}
