package com.korailtalk.server.db.coach.repository;

import com.korailtalk.server.db.coach.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    List<Coach> findByTimetableId(Long timetableId);
}
