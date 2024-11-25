package com.korailtalk.server.api.seat.controller;

import com.korailtalk.server.api.common.dto.APISuccessResponse;
import com.korailtalk.server.api.seat.dto.request.SeatSelectRequest;
import com.korailtalk.server.api.seat.dto.response.SeatSelectResponse;
import com.korailtalk.server.api.seat.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @PostMapping("/seats")
    public ResponseEntity<APISuccessResponse<SeatSelectResponse>> selectSeat(
            @RequestHeader final Long userId,
            @RequestBody final SeatSelectRequest seatSelectRequest
            ){
        return APISuccessResponse.of(HttpStatus.OK,seatService.selectSeat(userId, seatSelectRequest));
    }

}
