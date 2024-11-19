package com.korailtalk.server.db.seat.entity;

import com.korailtalk.server.db.coach.entity.Coach;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coach_id", columnDefinition = "bigint", nullable = false)
    private Coach coach;

    @Column(name = "name", columnDefinition = "varchar(10)", nullable = false)
    private String name;

    @Column(name = "direction", columnDefinition = "boolean", nullable = false)
    private boolean direction;

    @Column(name = "seat_sold", columnDefinition = "boolean", nullable = false)
    private boolean seatSold;

    @Builder
    public Seat(final Coach coach, final String name, final boolean direction, final boolean seatSold){
        this.coach = coach;
        this.name = name;
        this.direction = direction;
        this.seatSold = seatSold;
    }
}
