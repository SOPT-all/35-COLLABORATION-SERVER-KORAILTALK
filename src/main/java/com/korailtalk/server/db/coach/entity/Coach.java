package com.korailtalk.server.db.coach.entity;

import com.korailtalk.server.db.seat.entity.Seat;
import com.korailtalk.server.db.ticket.entity.Ticket;
import com.korailtalk.server.db.timetable.entity.Timetable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "timetable_id", columnDefinition = "bigint", nullable = false)
    private Timetable timetable;

    @Column(name = "left_seats", columnDefinition = "int", nullable = false)
    private Integer leftSeats;

    @Column(name = "coaches_number", columnDefinition = "int", nullable = false)
    private Integer coachesNumber;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "coach", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats;

    @Builder
    public Coach(Timetable timetable, List<Ticket> tickets, List<Seat> seats, Integer leftSeats, Integer coachesNumber){
        this.timetable = timetable;
        this.tickets = tickets;
        this.seats = seats;
        this.leftSeats = leftSeats;
        this.coachesNumber = coachesNumber;
    }
}
