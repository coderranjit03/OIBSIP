package org.example.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pnr;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @Column(name = "class_type")
    private String classType;

    @Column(name = "journey_date")
    private LocalDate journeyDate;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate = LocalDateTime.now();

    @Column
    private String status = "BOOKED";

    // Constructors
    public Reservation() {}
    public Reservation(User user, Train train, String classType, LocalDate journeyDate) {
        this.user = user;
        this.train = train;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.status = "BOOKED";
    }

    // Getters and Setters
    public Long getPnr() { return pnr; }
    public void setPnr(Long pnr) { this.pnr = pnr; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Train getTrain() { return train; }
    public void setTrain(Train train) { this.train = train; }

    public String getClassType() { return classType; }
    public void setClassType(String classType) { this.classType = classType; }

    public LocalDate getJourneyDate() { return journeyDate; }
    public void setJourneyDate(LocalDate journeyDate) { this.journeyDate = journeyDate; }

    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}