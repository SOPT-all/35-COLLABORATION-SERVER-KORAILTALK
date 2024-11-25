package com.korailtalk.server.api.coach.controller;

import com.korailtalk.server.api.coach.dto.CoachesResponse;
import com.korailtalk.server.api.coach.service.CoachService;
import com.korailtalk.server.api.common.dto.APISuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/coaches")
@RequiredArgsConstructor
public class CoachController {

    private final CoachService coachService;

    @GetMapping("/{timetableId}")
    public ResponseEntity<APISuccessResponse<CoachesResponse>> getCoaches(
            @RequestHeader final Long userId,
            @PathVariable("timetableId") final Long timetableId
    ){
        return APISuccessResponse.of(HttpStatus.OK,coachService.getAllCoaches(userId, timetableId));
    }
}
