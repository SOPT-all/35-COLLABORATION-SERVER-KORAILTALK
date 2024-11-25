package com.korailtalk.server.db.seat.repository;

import com.korailtalk.server.db.seat.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByCoachId(Long coachId);
    Seat findFirstBySeatSoldFalseAndCoachIdOrderByIdAsc(Long coachId);
}
