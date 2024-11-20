package com.korailtalk.server.api.ticket.controller;

import com.korailtalk.server.api.common.dto.APISuccessResponse;
import com.korailtalk.server.api.ticket.dto.response.TicketResponse;
import com.korailtalk.server.api.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/{ticketId}")
    public ResponseEntity<APISuccessResponse<TicketResponse>> getTicket(
            @RequestHeader(name = "userId") final Long userId,
            @PathVariable(name = "ticketId") final Long ticketId
    ) {
        return APISuccessResponse.of(HttpStatus.OK, ticketService.getTicket(userId, ticketId));
    }

}
