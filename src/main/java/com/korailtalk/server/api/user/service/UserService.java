package com.korailtalk.server.api.user.service;

import com.korailtalk.server.api.common.enums.ErrorStatus;
import com.korailtalk.server.api.common.exception.NotFoundException;
import com.korailtalk.server.db.user.entity.User;
import com.korailtalk.server.db.user.repository.UserRepository;
import com.korailtalk.server.api.user.dto.response.LPointsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public LPointsResponse getLPoints(final Long userId, final int pointPassword) {

        final User findUser = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ErrorStatus.NOT_FOUND_USER)
        );

        if (findUser.getPointPassword() == pointPassword) {
            return LPointsResponse.of(true, findUser.getPoint());
        } else {
            return LPointsResponse.of(false, -1);
        }
    }

    @Transactional
    public void updatePoints(final Long userId, final int usedPoint) {
        final User findUser = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ErrorStatus.NOT_FOUND_USER)
        );

        findUser.updatePoint(usedPoint);
    }

}
