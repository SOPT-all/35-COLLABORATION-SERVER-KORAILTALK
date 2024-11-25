package com.korailtalk.server.api.seat.dto.response;

import lombok.Builder;

@Builder
public record SeatSelectResponse(
        long ticketId
) {
}
