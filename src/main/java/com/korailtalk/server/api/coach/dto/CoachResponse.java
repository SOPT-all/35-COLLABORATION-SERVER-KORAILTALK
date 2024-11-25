package com.korailtalk.server.api.coach.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CoachResponse(
        Long coachId,
        int leftSeats,
        List<SeatResponse> seats
) {

    public static CoachResponse of(final Long coachId, final int leftSeats, List<SeatResponse> seats){
        return new CoachResponse(coachId, leftSeats, seats);
    }
}
