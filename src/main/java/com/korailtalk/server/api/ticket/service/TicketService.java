package com.korailtalk.server.api.ticket.service;

import com.korailtalk.server.api.common.enums.ErrorStatus;
import com.korailtalk.server.api.common.exception.NotFoundException;
import com.korailtalk.server.api.ticket.dto.response.TicketResponse;
import com.korailtalk.server.db.coach.entity.Coach;
import com.korailtalk.server.db.seat.entity.Seat;
import com.korailtalk.server.db.ticket.entity.Ticket;
import com.korailtalk.server.db.ticket.repository.TicketRepository;
import com.korailtalk.server.db.timetable.entity.Timetable;
import com.korailtalk.server.db.train.entity.Train;
import com.korailtalk.server.db.user.entity.User;
import com.korailtalk.server.db.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public TicketResponse getTicket(final Long userId, final Long ticketId) {

        final User findUser = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException(ErrorStatus.NOT_FOUND_USER)
        );

        final Ticket findTicket = ticketRepository.findById(ticketId).orElseThrow(
                () -> new NotFoundException(ErrorStatus.NOT_FOUND_TICKET)
        );

        final Timetable findTimetable = findTicket.getTimetable();
        final Seat findSeat = findTicket.getSeat();
        final Coach findCoach = findTicket.getCoach();
        final Train findTrain = findTimetable.getTrain();

        return TicketResponse.builder()
                .departurePlace(findTimetable.getDeparturePlace())
                .arrivalPlace(findTimetable.getArrivalPlace())
                .date(findTimetable.getDate())
                .trainName(findTrain.getName())
                .departureTime(findTimetable.getDepartureAt())
                .arrivalTime(findTimetable.getArrivalAt())
                .seatName(findSeat.getName())
                .ticketPrice(findTicket.getPrice())
                .limitPaymentTime(findTicket.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .coachesNumber(findCoach.getCoachesNumber())
                .build();
    }

    @Transactional
    public void updateTicketPrices(final Long ticketId, final int totalPrice) {

        final Ticket findTicket = ticketRepository.findById(ticketId).orElseThrow(
                () -> new NotFoundException(ErrorStatus.NOT_FOUND_TICKET)
        );

        findTicket.updatePrice(totalPrice);
    }
}
