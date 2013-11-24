package q2;

import java.util.Random;
import java.util.Scanner;

/**
 * A program that generates a number from 1 to 100, and then asks the user to
 * guess it. The program logs each guess and displays the number of guesses the
 * user took to reach the correct number.
 * 
 * @author Christofer Klassen
 * @version 1.0
 */
public class Guess {

    /** A constant representing the max range of the guess. */
    public static final int MAX_RANGE = 100;

    /**
     * Generates a number and allows the user to guess. The user can also quit
     * the program/current guess at any time.
     * 
     * @param args
     *            is unused
     */
    public static void main(String[] args) {

        String holdGuess = ""; // temp holder for user input
        boolean quit = false; // whether or not the user quit the current game
        int guess = 0; // the user's guess
        int numGuesses = 0;
        String quitSentinel = "y"; // whether or not the user will play again
        int value = 0; // randomly generated number to guess
        Random gen = new Random();
        Scanner scan = new Scanner(System.in);

        // The loop that handles the main program
        while (!quitSentinel.equalsIgnoreCase("n")) {

            numGuesses = 0;
            quit = false;
            value = gen.nextInt(MAX_RANGE) + 1;

            System.out.println("Please guess a number between 1 and 100: ");

            if (scan.hasNextInt()) {
                guess = scan.nextInt();
            } else {
                throw new IllegalArgumentException("Invalid input.");
            }
            
            //checks validity of user guess
            while (guess < 1 || guess > MAX_RANGE) {
                System.out.println("Your guess must be between 1 and 100.");
                System.out.println("Please guess again: ");
                
                if (scan.hasNextInt()) {
                    guess = scan.nextInt();
                } else {
                    throw new IllegalArgumentException("Invalid input.");
                }
            }

            // the loop that handles each individual guess
            while (guess != value && !quit) {
                System.out.println("Incorrect! That number is too "
                        + (guess > value ? "high" : "low"));
                System.out.println("Please guess again (Enter q to quit):");

                holdGuess = scan.next();

                // if the input was 'q', quit, otherwise parse the guess out
                if (holdGuess.equalsIgnoreCase("q")) {
                    quit = true;
                } else {
                    guess = Integer.parseInt(holdGuess);
                    
                    //checks validity of new guess
                    while (guess < 1 || guess > MAX_RANGE) {
                        System.out.println("Your guess must be "
                                + "between 1 and 100.");
                        System.out.println("Please guess again: ");
                        
                        if (scan.hasNextInt()) {
                            guess = scan.nextInt();
                        } else {
                            throw new IllegalArgumentException("Invalid "
                                    + "input.");
                        }
                    }
                    
                    numGuesses++;
                }
            }

            numGuesses++;

            if (!quit) {
                System.out.println("Correct! You guessed the number in "
                        + numGuesses + " guesses.");
            }

            System.out.println("Do you want to play another game? (y/n)");
            quitSentinel = scan.next();

            scan.close();
        }
    }
}
