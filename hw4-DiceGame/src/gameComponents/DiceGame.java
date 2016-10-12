package gamecomponents;

import java.util.Random;

/**
 * Simulates a dice game where a Player and CPU each roll a pair of loaded die.
 *  The player will select HIGH or LOW, and the dice are rolled. Whoever rolls
 *  the higher or lower value (based on Player choice) wins the game. This
 *  game is skewed ~76% in favor of the CPU.
 * 
 * @author  Vincent T. Mossman
 * @version October 15, 2014 (v1.0)
 *
 */

public class DiceGame {
	
	/*   
	 *  Player and CPU will use a pair of loaded 6-sided dice, and each have a 60% chance
	 *   of rolling (w, x) and (y, z), respectively, where (y, z) beats (w, x). However, 
	 *   each also have a 40% change of rolling (a, p) and (b, q), where (a, p) != (w, x)
	 *   and (b, q) != (y, z). Because of math, the probability of (a, p) beating (b, q)
	 *   is 40%. Therefore, also due to math, the probability of the Player winning is
	 *   around 24%. (Trust the math)
	 *   
	 */
	
	//---------------------------------
	//Instance Constants
	//---------------------------------
	private static final double LOADED_PROBABILITY = 0.6;
	
	//---------------------------------
	//Instance Variables
	//---------------------------------
	private Die playerDie; 
	private Die cpuDie; 
	private Dice playerDice;
	private Dice cpuDice;
	private int playerLastRoll;
	private int cpuLastRoll;
	private String lastRoundGuess;
	private Random myRandomNumGenerator = new Random(); //Helps create illusion to user
														// that dice are not loaded
	
	//---------------------------------
	//Constructors
	//---------------------------------
	
	/**
	 * Default constructor creates an instance of the DiceGame and is ready to be used
	 *  to play the game
	 */
	public DiceGame()
	{
		//Initialize game Dies (multiple "Die", not die, I think it makes sense)
		this.playerDie = new LoadedDie(6, myRandomNumGenerator.nextInt(6) + 1, LOADED_PROBABILITY);	
		this.cpuDie    = new LoadedDie(6, myRandomNumGenerator.nextInt(6) + 1, LOADED_PROBABILITY);
		
		//Initialize game Dice
		this.playerDice = new Dice(0); //Creates a set of Dice containing 0 Dies,
		this.cpuDice    = new Dice(0); // they will be added in the next step
		
		//Create Dice
		this.playerDice.add(playerDie);
		this.playerDice.add(playerDie);
		this.cpuDice.add(cpuDie);
		this.cpuDice.add(cpuDie);
		
		//Set default rolls and guess
		this.playerLastRoll = 1; //These values SHOULDN'T be used without first
		this.cpuLastRoll    = 1; // playing a round, so values are space fillers
		this.lastRoundGuess = "";
	}

	//---------------------------------
	//Class Methods
	//---------------------------------
	
	/**
	 * Returns the value of CPUs last roll
	 * 
	 * @return Value of CPUs last roll
	 */
	public int getComputerRoll()
	{
		return this.cpuLastRoll;
	}
	
	/**
	 * Returns the value of the Player's last roll
	 * 
	 * @return Value of Player's last roll
	 */
	public int getPlayerRoll()
	{
		return this.playerLastRoll;
	}
	
	/**
	 * Returns a true if the Player's roll beats the computer's
	 *  roll based on the last round's guess of High or Low
	 *  
	 * @return True if Player is winner, else False
	 */
	public boolean isWinner()
	{
		if (this.lastRoundGuess.equals("HIGH"))
		{
			return this.playerLastRoll > this.cpuLastRoll;
		} else
		{
			return this.playerLastRoll < this.cpuLastRoll;
		}
	}
	
	/**
	 * Play a round of the game where the Player's and
	 *  CPUs dice are rolled and stored in the game object
	 */
	public void playRound(String playerGuess)
	{
		//Local Variables
		int playerLoadedValue = myRandomNumGenerator.nextInt(6) + 1; //Load to random value so it
		int cpuLoadedValue    = myRandomNumGenerator.nextInt(6) + 1; // appears slightly more fair
		
		//Ensure correct case for playerGuess
		playerGuess = playerGuess.toUpperCase();
		
		//Clear Dice
		this.playerDice = new Dice(0);
		this.cpuDice    = new Dice(0);
		
		//Ensure loaded values are in favor of CPU
		if (playerGuess.equals("HIGH"))
		{
			while (playerLoadedValue > cpuLoadedValue)
			{
				playerLoadedValue = myRandomNumGenerator.nextInt(6) + 1;
				cpuLoadedValue    = myRandomNumGenerator.nextInt(6) + 1;
			}
		} else
		{
			while (playerLoadedValue < cpuLoadedValue)
			{
				playerLoadedValue = myRandomNumGenerator.nextInt(6) + 1;
				cpuLoadedValue    = myRandomNumGenerator.nextInt(6) + 1;
			}
		}
		
		//Re-initialize Dies with new loadedValues
		this.playerDie = new LoadedDie(6, playerLoadedValue, LOADED_PROBABILITY);
		this.cpuDie	   = new LoadedDie(6, cpuLoadedValue, LOADED_PROBABILITY);
		
		//Re-initialize Dice with new loadedValues
		this.playerDice.add(playerDie);
		this.playerDice.add(playerDie);
		this.cpuDice.add(cpuDie);
		this.cpuDice.add(cpuDie);
		
		//Roll Dice and save values
		this.playerLastRoll = playerDice.roll();
		this.cpuLastRoll	= cpuDice.roll();
		
		//Save playerGuess
		this.lastRoundGuess = playerGuess;
	}
}
