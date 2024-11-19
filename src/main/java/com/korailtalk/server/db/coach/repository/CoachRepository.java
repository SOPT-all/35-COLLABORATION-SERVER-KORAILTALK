package com.korailtalk.server.db.coach.repository;

import com.korailtalk.server.db.coach.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
}
