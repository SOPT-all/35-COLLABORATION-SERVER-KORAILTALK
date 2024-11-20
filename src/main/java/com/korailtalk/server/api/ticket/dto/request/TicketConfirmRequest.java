package com.korailtalk.server.api.ticket.dto.request;

public record TicketConfirmRequest(
        Long ticketId,
        int totalPrice,
        int usedPoint
) {
}
