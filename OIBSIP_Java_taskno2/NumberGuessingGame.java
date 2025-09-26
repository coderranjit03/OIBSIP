import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int totalRounds = 3;
        int maxAttempts = 5;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + totalRounds + " rounds to play. Let's begin!\n");

        for (int round = 1; round <= totalRounds; round++) {
            int target = random.nextInt(100) + 1;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println(" Round " + round + " begins! Guess a number between 1 and 100.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (" + attemptsLeft + " attempts left): ");
                int guess = scanner.nextInt();

                if (guess == target) {
                    System.out.println("Correct! You guessed the number.");
                    guessedCorrectly = true;
                    totalScore += attemptsLeft * 10; // More attempts left = higher score
                    break;
                } else if (guess < target) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The correct number was: " + target);
            }

            System.out.println("🎯 Score after Round " + round + ": " + totalScore + "\n");
        }

        System.out.println("🏁 Game Over! Your final score is: " + totalScore);
        System.out.println("Thanks for playing!");
    }
}