# Online Reservation System (Spring Boot)

A simple command-line Online Reservation System built with Spring Boot (3.3.4), Java 17, Spring Data JPA (Hibernate), and MySQL. It allows registering users, searching trains, booking tickets, and canceling reservations through an interactive CLI menu.

## Tech Stack
- Java 17
- Spring Boot 3.3.4
- Spring Web (for application bootstrap)
- Spring Data JPA (Hibernate)
- MySQL (mysql-connector-j)
- Maven

## Features
- Register a user (username/password, simple role field)
- Search trains by source and destination
- Book a reservation (generates PNR)
- Cancel a reservation by PNR
- MySQL schema and seed sample trains via `online_reservation.sql`

## Project Structure
```
OIBSIP_java_task1/
├─ pom.xml
├─ online_reservation.sql
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ org/example/
│  │  │     ├─ OnlineReservationSystemApplication.java
│  │  │     ├─ entity/
│  │  │     │  ├─ Reservation.java
│  │  │     │  ├─ Train.java
│  │  │     │  └─ User.java
│  │  │     ├─ repository/
│  │  │     │  ├─ ReservationRepository.java
│  │  │     │  ├─ TrainRepository.java
│  │  │     │  └─ UserRepository.java
│  │  │     └─ service/
│  │  │        ├─ ReservationService.java
│  │  │        ├─ TrainService.java
│  │  │        └─ UserService.java
│  │  └─ resources/
│  │     └─ application.properties
│  └─ test/
```

## Prerequisites
- Java 17 (JDK)
- Maven 3.9+
- MySQL 8.x running locally

## Database Setup
1. Start MySQL and create the schema using the provided script:
   ```sql
   -- from MySQL shell or a client
   SOURCE /path/to/online_reservation.sql;
   ```
   This creates database `online_reservation`, tables (`users`, `trains`, `reservations`), and seeds a few trains.

2. Optionally verify:
   ```sql
   USE online_reservation;
   SHOW TABLES;
   SELECT * FROM trains;
   ```

## Configuration
Application properties are in `src/main/resources/application.properties`.

Example:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/online_reservation
spring.datasource.username=root
spring.datasource.password=********

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

server.port=8080
```

Security note: Do not commit real credentials. Prefer externalizing secrets using environment variables or a config server.

Example (run-time overrides):
```bash
# PowerShell
$env:SPRING_DATASOURCE_URL="jdbc:mysql://localhost:3306/online_reservation"
$env:SPRING_DATASOURCE_USERNAME="root"
$env:SPRING_DATASOURCE_PASSWORD="your_password"
```

## How to Run (Local)
- Using Maven (recommended during development):
  ```bash
  mvn spring-boot:run
  ```

- Using the packaged JAR:
  ```bash
  mvn clean package
  java -jar target/OIBSIP_java_task1-1.0-SNAPSHOT.jar
  ```

When the app starts, you will see an interactive menu in the console.

## CLI Usage
You will be prompted with options:
1. Register User
2. Search Trains
3. Book Ticket
4. Cancel Reservation
5. Exit

Follow on-screen prompts to perform each action. For booking:
- Provide existing `userId`
- Provide `trainNumber`
- Choose `classType`
- Provide `journeyDate` as YYYY-MM-DD

## Useful Maven Commands
- Build: `mvn clean package`
- Run: `mvn spring-boot:run`
- Tests (if added later): `mvn test`
- Dependency tree: `mvn dependency:tree`

## Troubleshooting
- Cannot connect to DB: Verify MySQL is running and credentials/URL in `application.properties` (or env vars) are correct.
- Schema missing: Run `online_reservation.sql` to create the database and tables.
- Java version errors: Ensure JDK 17 is installed and active (`java -version`).

## Future Improvements
- Add REST endpoints and controllers for non-interactive usage
- Add authentication/authorization (Spring Security, password hashing)
- Add integration/unit tests
- Validation and error handling enhancements
- Dockerize app and database
