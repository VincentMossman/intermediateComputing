package gamecomponents;

/**
 * The LoadedDie class represents a loaded die
 * 
 * @author  Vincent T. Mossman
 * @version October 15, 2014 (v1.1)
 *
 */

public class LoadedDie extends Die
{
	//---------------------------------
	//Instance Variables
	//---------------------------------
	
	private int    loadedValue; //Value to skew in favor of
	private double percentage;  //Percentage value between 0.0 and 1.0
	
	//---------------------------------
	//Constructors
	//---------------------------------
	
	/**
	 * Default constructor creates a six-sided die that is loaded 90%
	 *  to the value 6
	 */
	public LoadedDie()
	{
		super();
		this.loadedValue = 6;
		this.percentage  = 0.9;
	}
	
	/**
	 * This constructor takes in the number of sides, the loaded value,
	 *  and the percentage
	 *  
	 * @param aNumSides    Number of sides 
	 * @param aLoadedValue Value to skew in favor of
	 * @param aPercentage  Percentage of skew (Value between 0.0 and 1.0)
	 */
	public LoadedDie(int aNumSides, int aLoadedValue, double aPercentage)
	{
		super(aNumSides);
		this.loadedValue = aLoadedValue;
		this.percentage  = aPercentage;
	}
	
	
	//---------------------------------
	//Class Methods
	//---------------------------------
	
	/**
	 * Rolls the Die; returns skewed value
	 * 
	 * @return Integer value representing loaded roll
	 */
	public int roll()
	{
		//Local Variables
		double randomSkew; //Determines, via given percentage, how often to roll loaded value
		int	   randomElse; //When loaded value is not rolled, determines which value to return
		int[]  dieValueArray = new int[this.numSides - 1];
		
		//Initialize Variables
			//Generate random value between 0.0 and 1.0
		randomSkew = myRandomNumGenerator.nextDouble();
			//Generate random value between 0 and numSides - 1
		randomElse = myRandomNumGenerator.nextInt(this.numSides - 1);
			//Fill array with all possible roll values except
			// the loaded value
		for (int i = 0; i < this.numSides - 1; i++)
		{
				//(i+1) = Array position where slot 0 is position 1
			if ((i + 1) < this.loadedValue)
			{
				dieValueArray[i] = i + 1; //Array slot value = Array position
			} else
			{
				dieValueArray[i] = i + 2; //Skips loadedValue
			}
		}
		
		if (randomSkew <= this.percentage)
		{
			//Returns loadedValue (percentage * 100)% of the time
			return this.loadedValue;
		} else
		{
			//Returns a value from a randomly selected slot of
			// dieValueArray (equal probability for each slot)
			return dieValueArray[randomElse];
		}
	}
	
}
