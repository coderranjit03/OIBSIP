package org.example;

import org.example.entity.User;
import org.example.entity.Reservation;
import org.example.entity.Train;
import org.example.service.UserService;
import org.example.service.ReservationService;
import org.example.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class OnlineReservationSystemApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private TrainService trainService;

    public static void main(String[] args) {
        SpringApplication.run(OnlineReservationSystemApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Welcome to Online Reservation System ===");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Register User");
            System.out.println("2. Search Trains");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();
                    User user = new User(username, password, "USER");
                    userService.register(user);
                    System.out.println("✅ User registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter source: ");
                    String source = sc.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = sc.nextLine();
                    List<Train> trains = trainService.searchTrains(source, destination);
                    if (trains.isEmpty()) {
                        System.out.println("❌ No trains found for this route.");
                    } else {
                        System.out.println("Available trains:");
                        trains.forEach(t -> System.out.println(
                                t.getTrainNumber() + " - " + t.getTrainName()
                        ));
                    }
                    break;

                case 3:
                    System.out.print("Enter user ID: ");
                    Long userId = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Enter train number: ");
                    String trainNumber = sc.nextLine();
                    System.out.print("Enter class type: ");
                    String classType = sc.nextLine();
                    System.out.print("Enter journey date (YYYY-MM-DD): ");
                    String dateStr = sc.nextLine();
                    LocalDate journeyDate = LocalDate.parse(dateStr);

                    try {
                        Reservation res = reservationService.createReservation(
                                userId, trainNumber, classType, journeyDate
                        );
                        System.out.println("✅ Ticket booked! PNR: " + res.getPnr());
                    } catch (Exception e) {
                        System.out.println("❌ Booking failed: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter PNR to cancel: ");
                    Long pnr = sc.nextLong();
                    sc.nextLine();
                    try {
                        Reservation cancelled = reservationService.cancelReservation(pnr);
                        System.out.println("✅ Reservation cancelled. Status: " + cancelled.getStatus());
                    } catch (Exception e) {
                        System.out.println("❌ Cancellation failed: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("👋 Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}