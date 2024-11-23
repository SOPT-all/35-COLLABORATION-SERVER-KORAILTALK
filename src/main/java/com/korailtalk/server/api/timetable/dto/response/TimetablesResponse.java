package com.korailtalk.server.api.timetable.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record TimetablesResponse(
        List<TimetableResponse> timetables
) {

    public static TimetablesResponse of(List<TimetableResponse> timetables) {
        return new TimetablesResponse(timetables);
    }
}
