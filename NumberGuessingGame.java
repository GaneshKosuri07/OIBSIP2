import java.util.Random;
import java.util.Scanner;

class GuessNumber {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 100;
    private static final int MAX_ATTEMPTS = 7;
    private static final int ROUNDS = 3;

    private final Scanner scanner;
    private final Random random;

    GuessNumber() {
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void startGame() {
        System.out.println("Welcome to the Guess the Number Game!");

        int totalScore = 0;

        for (int round = 1; round <= ROUNDS; round++) {
            System.out.println("\nRound " + round + " of " + ROUNDS);

            int secretNumber = generateRandomNumber();

            int roundScore = playRound(secretNumber);
            totalScore += roundScore;
        }

        System.out.println("\nGame over! Your total score is: " + totalScore);
    }

    private int generateRandomNumber() {
        return RANGE_START + random.nextInt(RANGE_END - RANGE_START + 1);
    }

    private int playRound(int secretNumber) {
        int attempts = 0;
        int score = 0;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess (attempt " + (attempts + 1) + " of " + MAX_ATTEMPTS + "): ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You've guessed the number.");
                score = calculateScore(attempts);
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("The number is higher than your guess.");
            } else {
                System.out.println("The number is lower than your guess.");
            }
        }

        if (attempts == MAX_ATTEMPTS && score == 0) {
            System.out.println("Sorry! You've reached the maximum attempts. The secret number was: " + secretNumber);
        }

        return score;
    }

    private int calculateScore(int attempts) {
        return MAX_ATTEMPTS - attempts + 1;
    }
}

public class NumberGuessingGame{
    public static void main(String[] args) {
        GuessNumber game = new GuessNumber();
        game.startGame();
    }
}