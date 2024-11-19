package com.korailtalk.server.db.ticket.entity;

import com.korailtalk.server.db.coach.entity.Coach;
import com.korailtalk.server.db.seat.entity.Seat;
import com.korailtalk.server.db.timetable.entity.Timetable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "timetable_id", columnDefinition = "bigint", nullable = false)
    private Timetable timetable;

    @ManyToOne
    @JoinColumn(name = "seat_id", columnDefinition = "bigint", nullable = false)
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "coach_id", columnDefinition = "bigint", nullable = false)
    private Coach coach;

    @Column(name = "price", columnDefinition = "int", nullable = false)
    private Integer price;

    @Column(name = "create_at", columnDefinition = "varchar(20)", nullable = false)
    private String createAt;

    @Column(name = "ticket_confirm", columnDefinition = "boolean", nullable = false)
    private Boolean ticketConfirm;

    @Builder
    public Ticket(Timetable timetable, Seat seat, Coach coach, Integer price, String createAt, Boolean ticketConfirm){
        this.timetable = timetable;
        this.seat = seat;
        this.coach = coach;
        this.price = price;
        this.createAt = createAt;
        this.ticketConfirm = ticketConfirm;
    }

}
