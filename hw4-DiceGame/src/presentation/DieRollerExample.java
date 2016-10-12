package presentation;

import gamecomponents.DiceGame;
import java.util.Scanner;

    /**
     * This is the main class for the first die example.
     *  
     * @author Michael J. Holmes
     * @version 2.0 February 5, 2013
     * 
     */

public class DieRollerExample {

    /**
     * The main program that runs, and prints out the results of rolling a die twice
     * to the console.
     *  
     * @param args Standard input argument list that is not used in this program.
     * 
     */
    
	
	public static void main(String[] args)
	{

	    System.out.println("Welcome to the High-Low dice game.");

	   
        //Local variables 	
    	DiceGame myGame = new DiceGame();
        String reRoll = "Y";
        String guess = "";
    	Scanner in = new Scanner(System.in);
        
        //Get user input

    	
       while (reRoll.toUpperCase().startsWith("Y"))
       {	  
           
           System.out.println();
           
           while (!guess.toUpperCase().equals("LOW") && !guess.toUpperCase().equals("HIGH"))
           {
               System.out.print("Do you pick High or Low?:  ");
               guess = in.next();
           }

           myGame.playRound(guess);
           
           System.out.println("You rolled: " + myGame.getPlayerRoll() + " the computer rolled: " + myGame.getComputerRoll() );
           
           if (myGame.isWinner())
           {
               System.out.println("You win!");
           }
           else
           {
               System.out.println("Sorry!  You lose!");
           }
    
           //Reset the guess
           guess = "";
           
           //Prompt user to roll again
           System.out.println();
           System.out.print("Would you like to play again?: ");
           reRoll = in.next(); 
       }

           
       System.out.print("Bye");
      
       //This was bothering me so I closed it
       in.close();
	}	
}
