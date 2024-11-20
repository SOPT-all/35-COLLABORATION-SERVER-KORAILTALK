package com.korailtalk.server.api.user.controller;

import com.korailtalk.server.api.common.dto.APISuccessResponse;
import com.korailtalk.server.api.user.service.UserService;
import com.korailtalk.server.api.user.dto.resopnse.LPointsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/points")
    public ResponseEntity<APISuccessResponse<LPointsResponse>> getLPoints(
            @RequestHeader final Long userId,
            @RequestParam(name = "pointPassword") final int pointPassword
    ) {
        return APISuccessResponse.of(HttpStatus.OK, userService.getLPoints(userId, pointPassword));
    }

}
