package com.korailtalk.server.api.seat.dto.request;

public record SeatSelectRequest(
        boolean isAuto,
        long coachId,
        long seatId,
        long timetableId,
        int price
) {
}
