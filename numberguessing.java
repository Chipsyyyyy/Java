import java.util.Random;
import java.util.Scanner;

public class numberguessing {

    private static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args){
        randNumber();
    }

    public static void randNumber(){
        System.out.println("Enter the highest number:");
        while (!myScanner.hasNextInt()) {
            System.out.println("Invalid Input. Please enter a number:");
            myScanner.next();
        }
        
        int largestNum = myScanner.nextInt();
        
        Random rand = new Random();
        int randomNumber = rand.nextInt(largestNum) + 1;
        System.out.println("Your range is from 1 - " + largestNum);
        System.out.println(randomNumber);
        guess(randomNumber);
    }

    public static void guess(int number){
        int counter = 0;
        System.out.println("Guess your random number:");
        
        while(!myScanner.hasNextInt()){
            System.out.println("Invalid Input. Please enter a number:");
            myScanner.next();
        }
        int guess = myScanner.nextInt();

        while(guess != number){
            counter++;
            
            System.out.println("Wrong");
            
            if(guess > number){
                System.out.println("Your guess is above the range");
            }
            else if(guess < 1){
                System.out.println("Your guess is under the range");
            }
            System.out.println("You have " + counter + " guess/es so far");
            System.out.println("Guess again:");
            guess = myScanner.nextInt();
        }
            
        counter++;
        System.out.println("Correct! The number was " + number);
        System.out.println("It took you " + counter + " attempts");
        continueGame();
    }

    public static void continueGame(){
        System.out.println("Play again? (Y/N)");
        String continueAnswer = myScanner.next();

        if (continueAnswer.equals("Y") || continueAnswer.equals("y")) {
            main(null);
        }

        else if (continueAnswer.equals("N") || continueAnswer.equals("n")) {
            System.exit(0);
        }

        else{
            System.out.println("Please enter (Y/N)");
            continueGame();
        }
    }
}