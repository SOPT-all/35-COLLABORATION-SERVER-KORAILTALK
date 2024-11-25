package com.korailtalk.server.api.coach.dto;

import lombok.Builder;

@Builder
public record SeatResponse(
        Long seatId,
        String seatName,
        boolean direction,
        boolean isSold
) {
    public static SeatResponse of(final Long seatId, final String seatName, final boolean direction, final boolean isSold){
        return new SeatResponse(seatId, seatName, direction,isSold);
    }
}
