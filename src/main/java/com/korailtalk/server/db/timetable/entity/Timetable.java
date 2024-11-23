package com.korailtalk.server.db.timetable.entity;

import com.korailtalk.server.db.train.entity.Train;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name="timetables")
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    @Column(name = "departure_at", columnDefinition = "varchar(10)", nullable = false)
    private String departureAt;

    @Column(name = "arrival_at", columnDefinition = "varchar(10)", nullable = false)
    private String arrivalAt;

    @Column(name = "standard_price", columnDefinition = "int", nullable = false)
    private int standardPrice;

    @Column(name = "premium_price", columnDefinition = "int", nullable = false)
    private int premiumPrice;

    @Column(name = "standard_sold", columnDefinition = "boolean", nullable = false)
    private boolean standardSold;

    @Column(name = "premium_sold", columnDefinition = "boolean", nullable = false)
    private boolean premiumSold;

    @Column(name = "departure_place", columnDefinition = "varchar(10)", nullable = false)
    private String departurePlace;

    @Column(name = "arrival_place", columnDefinition = "varchar(10)", nullable = false)
    private String arrivalPlace;

    @Column(name = "date", columnDefinition = "varchar(20)", nullable = false)
    private String date;

    @Column(name = "travel_time", columnDefinition = "int", nullable = false)
    private int travelTime;


    @Builder
    public Timetable(final Train train,
                     final String departureAt, final String arrivalAt,
                     final int standardPrice, final int premiumPrice, final boolean standardSold, final boolean premiumSold,
                     final String departurePlace, final String arrivalPlace, final String date, final int travelTime){
        this.train = train;
        this.departureAt = departureAt;
        this.arrivalAt = arrivalAt;
        this.standardPrice = standardPrice;
        this.premiumPrice = premiumPrice;
        this.standardSold = standardSold;
        this.premiumSold = premiumSold;
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;
        this.date = date;
        this.travelTime = travelTime;
    }
}
