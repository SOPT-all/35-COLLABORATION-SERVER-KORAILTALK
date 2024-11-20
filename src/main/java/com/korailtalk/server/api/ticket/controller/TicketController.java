package com.korailtalk.server.api.ticket.controller;

import com.korailtalk.server.api.common.dto.APISuccessResponse;
import com.korailtalk.server.api.ticket.dto.request.TicketConfirmRequest;
import com.korailtalk.server.api.ticket.dto.response.TicketResponse;
import com.korailtalk.server.api.ticket.service.TicketService;
import com.korailtalk.server.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    private final UserService userService;

    @GetMapping("/{ticketId}")
    public ResponseEntity<APISuccessResponse<TicketResponse>> getTicket(
            @RequestHeader(name = "userId") final Long userId,
            @PathVariable(name = "ticketId") final Long ticketId
    ) {
        return APISuccessResponse.of(HttpStatus.OK, ticketService.getTicket(userId, ticketId));
    }

    @PatchMapping
    public ResponseEntity<APISuccessResponse<Void>> confirmTicket(
            @RequestHeader(name = "userId") final Long userId,
            @RequestBody final TicketConfirmRequest ticketConfirmRequest
    ) {
        userService.updatePoints(userId, ticketConfirmRequest.usedPoint());
        ticketService.updateTicketPrices(ticketConfirmRequest.ticketId(), ticketConfirmRequest.totalPrice());
        return APISuccessResponse.of(HttpStatus.NO_CONTENT, null);

    }

}
