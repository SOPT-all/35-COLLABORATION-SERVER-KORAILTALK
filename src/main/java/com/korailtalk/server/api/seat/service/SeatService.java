package com.korailtalk.server.api.seat.service;

import com.korailtalk.server.api.common.enums.ErrorStatus;
import com.korailtalk.server.api.common.exception.NotFoundException;
import com.korailtalk.server.api.seat.dto.request.SeatSelectRequest;
import com.korailtalk.server.api.seat.dto.response.SeatSelectResponse;
import com.korailtalk.server.db.coach.repository.CoachRepository;
import com.korailtalk.server.db.seat.entity.Seat;
import com.korailtalk.server.db.seat.repository.SeatRepository;
import com.korailtalk.server.db.ticket.entity.Ticket;
import com.korailtalk.server.db.ticket.repository.TicketRepository;
import com.korailtalk.server.db.timetable.repository.TimetableRepository;
import com.korailtalk.server.db.user.entity.User;
import com.korailtalk.server.db.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final SeatRepository seatRepository;
    private final TimetableRepository timetableRepository;
    private final CoachRepository coachRepository;

    public SeatSelectResponse selectSeat(Long userId, SeatSelectRequest seatSelectRequest){
        final User user = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ErrorStatus.NOT_FOUND_USER)
        );

        Long finalTicketId;

        if (seatSelectRequest.isAuto()) {
            Ticket newTicket = Ticket.builder()
                    .seat(seatRepository.findById(seatSelectRequest.seatId()).orElseThrow(
                            () -> new NotFoundException(ErrorStatus.NOT_FOUND_SEAT)))
                    .price(seatSelectRequest.price())
                    .ticketConfirm(false)
                    .timetable(timetableRepository.findById(seatSelectRequest.timetableId()).orElseThrow(
                            () -> new NotFoundException(ErrorStatus.NOT_FOUND_TIMETABLE)))
                    .coach(coachRepository.findById(seatSelectRequest.coachId()).orElseThrow(
                            () -> new NotFoundException(ErrorStatus.NOT_FOUND_TIMETABLE)))
                    .build();

            Ticket savedTicket = ticketRepository.save(newTicket);
            finalTicketId = savedTicket.getId();
        } else {

            // 1. CoachId 받아오기
            // 2. 해당 CoachID 중에 isSold == false 인 것 중에 첫번째 반환
            Seat seat = seatRepository.findFirstBySeatSoldFalseAndCoachIdOrderByIdAsc(seatSelectRequest.coachId());
                Ticket randomTicket = Ticket.builder()
                        .seat(seat)
                        .price(seatSelectRequest.price())
                        .ticketConfirm(false)
                        .timetable(timetableRepository.findById(seatSelectRequest.timetableId()).orElseThrow(
                                () -> new NotFoundException(ErrorStatus.NOT_FOUND_TIMETABLE)))
                        .coach(coachRepository.findById(seatSelectRequest.coachId()).orElseThrow(
                                () -> new NotFoundException(ErrorStatus.NOT_FOUND_TIMETABLE)))
                        .build();

            Ticket savedTicket = ticketRepository.save(randomTicket);
            finalTicketId = savedTicket.getId();
        }


        return SeatSelectResponse.builder()
                .ticketId(finalTicketId)
                .build();

    }
}
