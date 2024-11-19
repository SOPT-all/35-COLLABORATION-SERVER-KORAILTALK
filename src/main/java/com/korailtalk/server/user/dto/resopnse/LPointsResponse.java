package com.korailtalk.server.user.dto.resopnse;

public record LPointsResponse(
        boolean isValid,
        int point
) {

    public static LPointsResponse of(final boolean isValid, final int point) {
        return new LPointsResponse(isValid, point);
    }
}
