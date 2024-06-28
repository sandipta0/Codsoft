
package numbergame;
import java.util.Random;
import java.util.Scanner;

public class Numbergame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int ttlampt = 0;
        int rndwon = 0;
        int rndpld = 0;
        
        boolean playAgain = true;
        
        while (playAgain) {
       int minimum = 1;
        int maximum = 100;
        int maxAttempts = 5;

        Random random = new Random();

        int randomNumber = random.nextInt((maximum - minimum) + 1) + minimum;
       
        int userGuess = 0;
        int attempts = 0;
         while (userGuess != randomNumber && attempts < maxAttempts) {
             attempts++;
       System.out.println("Attempt " + attempts + ": Guess number between " + minimum + " and " + maximum + ": "); 
        
        userGuess = scanner.nextInt();
        
         if (userGuess == randomNumber) {
            System.out.println("Congratulations! guess the correct number: " + randomNumber);
        } else if (userGuess < randomNumber) {
            System.out.println("Guess is low. The correct number was: " + randomNumber);
        } else {
            System.out.println("Guess is high. The correct number was: " + randomNumber);
        }
         }
          rndpld++;
          
           ttlampt += attempts;
           
         if (userGuess != randomNumber) {
            System.out.println("Sorry, you used all " + maxAttempts + " attempts. The correct number was: " + randomNumber);
        }
         System.out.println("Score: Rounds Played = " + rndpld + ", Rounds Won = " + rndwon + ", Total Attempts = " + ttlampt);
         
         System.out.println("If you want to play again just type? (yes/no): ");
         
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

         scanner.close();
         System.out.println("Thank you for playing this game!");
    }
    
}
