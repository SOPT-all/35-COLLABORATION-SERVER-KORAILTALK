package com.korailtalk.server.api.coach.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CoachesResponse(
        List<CoachResponse> coaches
) {

    public static CoachesResponse of(List<CoachResponse> coaches){
        return new CoachesResponse(coaches);
    }
}
