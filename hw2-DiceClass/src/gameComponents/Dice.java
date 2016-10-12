package gamecomponents;

import java.util.ArrayList;

/**
 * The Dice class represents a collection of Die objects
 * 
 * @author  Vincent T. Mossman
 * @version September 28, 2014 (v1.0)
 *
 */

public class Dice extends Die
{
	//---------------------------------
	//Instance Variables
	//---------------------------------
	
	private ArrayList<Die> diceArray;
	
	//---------------------------------
	//Constructors
	//---------------------------------
	
	/**
	 * Default Constructor - Creates Dice object with 2 
	 *  6-sided Dice
	 */
	public Dice()
	{		
		//Initialize ArrayList
		this.diceArray = new ArrayList<Die>();
		
		//Fill ArrayList with default amount of Die
		for (int i = 0; i < 2; i++)
		{
			this.diceArray.add(new Die());
		}
	}
	
	/**
	 * This constructor takes an ArrayList of Die and creates
	 *  a Dice object
	 *  
	 * @param someDice ArrayList of Die to create Dice object from
	 */
	public Dice(ArrayList<Die> someDice)
	{
		//Initialize ArrayList
		this.diceArray = new ArrayList<Die>();
		
		//Fill ArrayList with someDice
		for (int i = 0; i < someDice.size(); i++)
		{
			this.diceArray.add(someDice.get(i));
		}
	}
	
	/**
	 * This constructor takes an integer value and creates
	 *  a Dice object with that number of 6-sided Die
	 *  
	 * @param numDice Number of 6-sided Die in Dice object
	 */
	public Dice(int numDice)
	{
		//Initialize ArrayList
		this.diceArray = new ArrayList<Die>();
		
		//Fill ArrayList with numDice Die
		for (int i = 0; i < numDice; i++)
		{
			this.diceArray.add(new Die());
		}
	}
	
	/**
	 * This constructor takes two integer values and creates
	 *  a Dice object with a user defined amount of Dice of 
	 *  custom numbered sides
	 *  
	 * @param numDice Number of Die objects in Dice object
	 * @param numSides Number of sides for each Die
	 */
	public Dice(int numDice, int numSides)
	{
		//Initialize ArrayList
		this.diceArray = new ArrayList<Die>();
		
		//Fill ArrayList with numDice numSides sided Die
		for (int i = 0; i < numDice; i++)
		{
			this.diceArray.add(new Die(numSides));
		}
	}
	
	//---------------------------------
	//Class Methods
	//---------------------------------
	
	/**
	 * Gets information about all Die in an object
	 * 
	 * @return String value representing all dice 
	 */
	public String containsDice()
	{
		//Local Variables
		String arrayValues;
		
		//Initialize Variables
		arrayValues = "(";
		
		//Concatenate all Die values to end of string
		for (int i = 0; i < this.diceArray.size(); i++)
		{
			arrayValues += " " + this.diceArray.get(i).getNumOfSides();
		}
		
		//Append closing parenthesis and return
		return arrayValues + " )";
	}
	
	/**
	 * Rolls all dice
	 * 
	 * @return Sum of all Dice rolled
	 */
	public int roll()
	{
		//Local Variables
		int rollSum = 0;
		
		//Roll all dice and increment rollSum
		for (int i = 0; i < this.diceArray.size(); i++)
		{
			rollSum += this.diceArray.get(i).roll();
		}
		
		return rollSum;
	}
	
	/**
	 * Adds a Die object to a Dice object
	 * 
	 * @param aDie Die to add to Dice
	 */
	public void add(Die aDie)
	{
		this.diceArray.add(aDie);
	}
}
