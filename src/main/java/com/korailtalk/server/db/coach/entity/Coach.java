package com.korailtalk.server.db.coach.entity;

import com.korailtalk.server.db.timetable.entity.Timetable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timetable_id", columnDefinition = "bigint", nullable = false)
    private Timetable timetable;

    @Column(name = "left_seats", columnDefinition = "int", nullable = false)
    private int leftSeats;

    @Column(name = "coaches_number", columnDefinition = "int", nullable = false)
    private int coachesNumber;

    @Builder
    public Coach(final Timetable timetable, final int leftSeats, final int coachesNumber){
        this.timetable = timetable;
        this.leftSeats = leftSeats;
        this.coachesNumber = coachesNumber;
    }
}
