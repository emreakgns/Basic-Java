

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasWon = false;
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            
            while (!hasWon) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                
                attempts++;
                
                if (guess == secretNumber) {
                    hasWon = true;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            System.out.println("Congratulations! You won in " + attempts + " attempts.");
        }
    }
}

