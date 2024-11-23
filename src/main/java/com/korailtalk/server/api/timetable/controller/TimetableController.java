package com.korailtalk.server.api.timetable.controller;

import com.korailtalk.server.api.common.dto.APISuccessResponse;
import com.korailtalk.server.api.timetable.dto.response.TimetablesResponse;
import com.korailtalk.server.api.timetable.service.TimetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor // final 필드나 @NonNull 필드를 초기화하는 생성자를 자동으로 생성
public class TimetableController {

    private final TimetableService timetableService;

    @GetMapping("/trains")
    public ResponseEntity<APISuccessResponse<TimetablesResponse>> getTimetables(
            @RequestHeader final Long userId,
            @RequestParam(name="date") final String date,
            @RequestParam(name="departurePlace") final String departurePlace,
            @RequestParam(name="arrivalPlace") final String arrivalPlace
    ){
        return APISuccessResponse.of(HttpStatus.OK,timetableService.getAllTimetables(userId, date, departurePlace, arrivalPlace));
    }
}
