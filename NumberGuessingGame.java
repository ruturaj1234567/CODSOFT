//TASK-2


//***************************************************************************//

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private int targetNumber;
    private int maxAttempts;
    private int attemptsLeft;
    private int score;

    public NumberGuessingGame(int minNum, int maxNum, int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.attemptsLeft = maxAttempts;
        this.score = 0;
        generateRandomNumber(minNum, maxNum);
    }

    // Method to generate a random number within a range
    private void generateRandomNumber(int minNum, int maxNum) {
        Random rand = new Random();
        targetNumber = rand.nextInt(maxNum - minNum + 1) + minNum;
    }

    // Method to handle user guesses
    public boolean guessNumber(int userGuess) {
        attemptsLeft--;
        
        if (userGuess == targetNumber) {
            System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
            score++;
            return true;
        } else if (userGuess > targetNumber) {
            System.out.println("Your guess is too high. Attempts left: " + attemptsLeft);
        } else {
            System.out.println("Your guess is too low. Attempts left: " + attemptsLeft);
        }

        if (attemptsLeft == 0) {
            System.out.println("Out of attempts! The correct number was: " + targetNumber);
        }
        return false;
    }

    // Method to start a new round
    public void startNewRound(int minNum, int maxNum) {
        generateRandomNumber(minNum, maxNum);
        attemptsLeft = maxAttempts;
        System.out.println("\nNew number generated! Start guessing.");
    }

    // Main method for gameplay
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minNum = 1, maxNum = 100, maxAttempts = 5;
        NumberGuessingGame game = new NumberGuessingGame(minNum, maxNum, maxAttempts);

        boolean playAgain;
        do {
            boolean guessedCorrectly = false;
            while (game.attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                guessedCorrectly = game.guessNumber(userGuess);
            }

            System.out.println("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
            if (playAgain) {
                game.startNewRound(minNum, maxNum);
            }
        } while (playAgain);

        System.out.println("Game over! Your final score is: " + game.score);
        scanner.close();
    }
}
