package com.korailtalk.server.db.ticket.entity;

import com.korailtalk.server.db.BaseTimeEntity;
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
@Table(name = "tickets")
public class Ticket extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timetable_id", columnDefinition = "bigint", nullable = false)
    private Timetable timetable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", columnDefinition = "bigint", nullable = false)
    private Seat seat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id", columnDefinition = "bigint", nullable = false)
    private Coach coach;

    @Column(name = "price", columnDefinition = "int", nullable = false)
    private int price;

    @Column(name = "ticket_confirm", columnDefinition = "boolean", nullable = false)
    private boolean ticketConfirm;

    @Builder
    public Ticket(final Timetable timetable, final Seat seat, final Coach coach, final int price, final boolean ticketConfirm) {
        this.timetable = timetable;
        this.seat = seat;
        this.coach = coach;
        this.price = price;
        this.ticketConfirm = ticketConfirm;
    }

    public void updatePrice(final int totalPrice) {
        this.price = totalPrice;
    }

}
