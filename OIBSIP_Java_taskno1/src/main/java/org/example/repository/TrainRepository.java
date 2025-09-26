package org.example.repository;

import org.example.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Long> {

    // Find train by its number
    Optional<Train> findByTrainNumber(String trainNumber);

    // Find trains by source and destination
    List<Train> findBySourceAndDestination(String source, String destination);
}