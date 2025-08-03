package com.guess_the_num;
import java.util.Random;
import javax.swing.JOptionPane;
//The game starts by displaying a message box asking the user to guess the number. 
//The user then enters their guess in a dialogue box. The program checks if the guess matches the generated number or if it is too high or too low. 
//If the guess is correct, 
//a message box is displayed congratulating the user and asking if they want to play again. If the user chooses to play again, 
//a new random number is generated and the game continues.
//If the user chooses to quit, their final score (calculated based on the number of attempts) is displayed.

public class num_guess_game {
    public static void main(String[] args) {
        int min = 1; // minimum value for the random number
        int max = 100; // maximum value for the random number
        int attempts = 0; // number of attempts made by the user
        int score = 0; // score of the user
        
        //Manjit using for learning purpose
        //In this implementation, the `Random` class is used to generate a random number between the given range.
        //The `JOptionPane` class is used to display a dialogue box for user input and output.
        
        
        
        Random rand = new Random();
        int number = rand.nextInt(max - min + 1) + min; // generate a random number
        
        JOptionPane.showMessageDialog(null, "Guess the number between " + min + " and " + max);
        
        while (true) {
            String input = JOptionPane.showInputDialog(null, "Enter your guess:");
            int guess = Integer.parseInt(input);
            attempts++;
            
            if (guess == number) {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.");
                score += max - attempts; // calculate score based on the number of attempts
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
                
                if (choice == JOptionPane.YES_OPTION) { 
                	// play again
                    number = rand.nextInt(max - min + 1) + min;
                    attempts = 0;
                    continue;
                } else { // quit
                    JOptionPane.showMessageDialog(null, "Your final score is " + score);
                    break;
                }
            } else if (guess < number) {
                JOptionPane.showMessageDialog(null, "Your guess is too low. Try again.");
            } else {
                JOptionPane.showMessageDialog(null, "Your guess is too high. Try again.");
            }
            
            if (attempts == 10) { 
            	// limit the number of attempts
                JOptionPane.showMessageDialog(null, "Sorry, you have reached the maximum number of attempts.");
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
                
                if (choice == JOptionPane.YES_OPTION) { // play again
                    number = rand.nextInt(max - min + 1) + min;
                    attempts = 0;
                    continue;
                } else { // quit
                    JOptionPane.showMessageDialog(null, "Your final score is " + score);
                    break;
                }
            }
            
        }
    }


}
