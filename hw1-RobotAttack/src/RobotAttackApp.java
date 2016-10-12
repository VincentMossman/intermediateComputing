import java.util.Scanner;

	/**
	 * HW1-RobotAttackApp - Application simulates robot apocalypse
	 * 
	 * @author Vincent T. Mossman
	 * @version September 17, 2014 (v1.0)
	 *
	 */
@SuppressWarnings("resource")
public class RobotAttackApp 
{

	public static void main(String[] args)
	{
		//Local variables
		Robot   Player;
		Robot   CPU;
		Scanner consoleInput = new Scanner(System.in);  //Used for user input
		String  userChoice;
		
		//Initialize Robot variables
		Player = new Robot();
		CPU    = new Robot();
		
		while (!Player.isDisabled() && !CPU.isDisabled())
		{
			//Display robot condition
			System.out.println("Player's robot is " + Player.getCurrentStatus() + "\tComputer robot is " + CPU.getCurrentStatus());
			
			//Prompt user for next player move
			System.out.print("(L)aser attack, (R)ocket attack, or (P)ower up? ");
			userChoice = consoleInput.next();
			
			//Execute player action and display results
				//NOTICE - there is no data validation for user input per assignment requirements
			switch (userChoice.toUpperCase().charAt(0))
			{
				case 'L': //Laser attack
							if (Player.laserAttack(CPU))
							{
								System.out.println("\nPlayer hits computer with laser.");
							} else
							{
								System.out.println("\nPlayer misses computer with laser.");
							}
							break;
				case 'R': //Rocket attack
							if (Player.rocketAttack(CPU))
							{
								System.out.println("\nPlayer hits computer with rocket.");
							} else
							{
								System.out.println("\nPlayer misses computer with rocket.");
							};
							break;
				case 'P': //Power up
							Player.powerUp();
							System.out.println("\nPlayer powers up.");
							break;
			}
			
			// Execute CPU action and display results
			if (CPU.laserAttack(Player))
			{
				System.out.println("Computer hits player with laser.");
			} else
			{
				System.out.println("Computer misses player with laser.");
			};

		}

		//Announce winner
		if (Player.isDisabled() && CPU.isDisabled())
		{
			System.out.println("Both robots have been distroyed!");
		} else if (Player.isDisabled())
		{
			System.out.println("The computer has destroyed your robot!");
		} else
		{
			System.out.println("You destroyed the robot!");
		}
		
	}
}
