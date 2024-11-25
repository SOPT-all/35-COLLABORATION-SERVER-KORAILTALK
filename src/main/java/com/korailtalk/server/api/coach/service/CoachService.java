package com.korailtalk.server.api.coach.service;

import com.korailtalk.server.api.coach.dto.CoachResponse;
import com.korailtalk.server.api.coach.dto.CoachesResponse;
import com.korailtalk.server.api.coach.dto.SeatResponse;
import com.korailtalk.server.api.common.enums.ErrorStatus;
import com.korailtalk.server.api.common.exception.NotFoundException;
import com.korailtalk.server.db.coach.entity.Coach;
import com.korailtalk.server.db.coach.repository.CoachRepository;
import com.korailtalk.server.db.seat.entity.Seat;
import com.korailtalk.server.db.seat.repository.SeatRepository;
import com.korailtalk.server.db.timetable.entity.Timetable;
import com.korailtalk.server.db.timetable.repository.TimetableRepository;
import com.korailtalk.server.db.user.entity.User;
import com.korailtalk.server.db.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachService {

    private final CoachRepository coachRepository;
    private final SeatRepository seatRepository;
    private final UserRepository userRepository;
    private final TimetableRepository timetableRepository;

    @Transactional(readOnly = true)
    public CoachesResponse getAllCoaches(Long userId, Long timetableId){
        return CoachesResponse.of(getCoachList(userId, timetableId));
    }

    private List<CoachResponse> getCoachList(Long userId, Long timetableId){
        final User findUser = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ErrorStatus.NOT_FOUND_USER)
        );

        final Timetable findTimetable = timetableRepository.findById(timetableId).orElseThrow(
                () -> new NotFoundException(ErrorStatus.NOT_FOUND_TIMETABLE)

        );

        final List<Coach> findCoaches = coachRepository.findByTimetableId(timetableId);

        return findCoaches.stream().map(
                coach -> {
                    final List<Seat> findSeats = seatRepository.findByCoachId(coach.getId());

                    return CoachResponse.builder()
                            .coachId(coach.getId())
                            .leftSeats(coach.getLeftSeats())
                            .seats(getSeatList(findSeats))
                            .build();
                }
        ).toList();

    }

    private List<SeatResponse> getSeatList(List<Seat> seats){

        return seats.stream().map(
                seat -> {
                    return SeatResponse.builder()
                            .seatId(seat.getId())
                            .seatName(seat.getName())
                            .direction(seat.isDirection())
                            .isSold(seat.isSeatSold())
                            .build();
                }
                ).toList();
    }

}
