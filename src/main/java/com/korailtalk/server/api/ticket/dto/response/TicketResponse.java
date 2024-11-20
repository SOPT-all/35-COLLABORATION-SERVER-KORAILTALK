package com.korailtalk.server.api.ticket.dto.response;

import lombok.Builder;

@Builder
public record TicketResponse(
        String departurePlace,
        String arrivalPlace,
        String date,
        String trainName,
        String departureTime,
        String arrivalTime,
        String seatName,
        int ticketPrice,
        String limitPaymentTime,
        int coachesNumber
) {
}
