-- Create database
CREATE DATABASE online_reservation;
USE online_reservation;

-- Users Table
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) DEFAULT 'USER'
);

-- Trains Table
CREATE TABLE trains (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    train_number VARCHAR(20) UNIQUE NOT NULL,
    train_name VARCHAR(100) NOT NULL,
    source VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL
);

-- Reservations Table
CREATE TABLE reservations (
    pnr BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    train_id BIGINT,
    class_type VARCHAR(50),
    journey_date DATE,
    booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) DEFAULT 'BOOKED',
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (train_id) REFERENCES trains(id) ON DELETE CASCADE
);


INSERT INTO trains (train_number, train_name, source, destination)
VALUES 
('12345', 'Express A', 'Mumbai', 'Delhi'),
('67890', 'Superfast B', 'Pune', 'Bangalore'),
('54321', 'Passenger C', 'Chennai', 'Hyderabad');

select * from users;
select * from reservations;
select * from trains;
