package com.korailtalk.server.db.train.repository;

import com.korailtalk.server.db.train.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
}
