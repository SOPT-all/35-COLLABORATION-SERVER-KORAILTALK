package com.korailtalk.server.db.seat.entity;

import com.korailtalk.server.db.ticket.entity.Ticket;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private Long id;

    @Column(name = "name", columnDefinition = "varchar(10)", nullable = false)
    private String name;

    @Column(name = "direction", columnDefinition = "boolean", nullable = false)
    private boolean direction;

    @Column(name = "seat_sold", columnDefinition = "boolean", nullable = false)
    private boolean seatSold;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets;

    @Builder
    public Seat(List<Ticket> tickets, String name, Boolean direction, Boolean seatSold){
        this.tickets = tickets;
        this.name = name;
        this.direction = direction;
        this.seatSold = seatSold;
    }
}
