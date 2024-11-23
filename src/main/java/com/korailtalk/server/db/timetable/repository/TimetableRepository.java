package com.korailtalk.server.db.timetable.repository;

import com.korailtalk.server.db.timetable.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    List<Timetable> findByDateAndDeparturePlaceAndArrivalPlace(String date, String departurePlace, String arrivalPlace);
}
