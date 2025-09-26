# ATM Simulation (Java)

A console-based ATM simulation in Java supporting basic banking operations and a transaction history.

## Files
- `ATM.java` (entry point / UI)
- `BankOperations.java` (core operations: balance, deposit, withdraw, transfer)
- `Transaction.java` (transaction model)
- `TransactionHistory.java` (stores and prints history)
- `User.java` (user model, PIN handling)

## Requirements
- Java JDK 17+ installed and on your PATH

## How to Run
From this folder in a terminal (PowerShell on Windows):

```bash
javac *.java
java ATM
```

## Features
- Login with user ID and PIN
- Check balance
- Deposit and withdraw funds with validation
- Transfer between accounts (if supported in your implementation)
- View transaction history
- Exit safely

## Notes
- If compilation fails, ensure all `.java` files are in this same directory.
- If you see a `java: not found` or version error, ensure JDK is installed and `java -version` shows the expected version.

