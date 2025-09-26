package org.example.service;

import java.util.Optional;
import org.example.entity.Reservation;
import org.example.entity.Train;
import org.example.entity.User;
import org.example.repository.ReservationRepository;
import org.example.repository.TrainRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private UserRepository userRepository;

    public Reservation createReservation(Long userId, String trainNumber, String classType, LocalDate journeyDate) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Train train = trainRepository.findByTrainNumber(trainNumber)
                .orElseThrow(() -> new RuntimeException("Train not found"));

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setTrain(train);
        reservation.setClassType(classType);
        reservation.setJourneyDate(journeyDate);
        reservation.setStatus("BOOKED");

        return reservationRepository.save(reservation);
    }

    public Reservation cancelReservation(Long pnr) {
        Reservation reservation = reservationRepository.findByPnr(pnr)
                .orElseThrow(() -> new RuntimeException("PNR not found"));

        reservation.setStatus("CANCELLED");
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> getReservation(Long pnr) {
        return reservationRepository.findByPnr(pnr);
    }
}