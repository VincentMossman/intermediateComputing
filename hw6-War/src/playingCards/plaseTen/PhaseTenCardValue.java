package playingcards.phaseten;

/** 
 * PhaseTenCardValue is an enumeration that contains all the valid values for a
 *  PhaseTenCard: 1 - 12, Wild, and Skip. It also includes a toString method.
 * 
 * @author  Vincent T. Mossman (based on code written by Mike J. Holmes)
 * @version November 5, 2014 (v1.0)
 */

public enum PhaseTenCardValue
{
	//---------------------------------
	//Phase Ten Card Values
	//---------------------------------
	
	ONE("One"), TWO("Two"), THREE("Three"), FOUR("Four"), FIVE("Five"), SIX("Six"),
	 SEVEN("Seven"),EIGHT("Eight"), NINE("Nine"), TEN("Ten"), ELEVEN("Eleven"),
	 TWELVE("Twelve"), WILD("Wild"), SKIP("Skip");
	
	//---------------------------------
	//Instance Variables
	//---------------------------------
	
	private String value;
	
	//---------------------------------
	//Constructors
	//---------------------------------
	
	/**
	 * Constructs a value that stores the string representation of that value
	 * 
	 * @param aValue String representation of a value
	 */
	private PhaseTenCardValue(String aValue)
	{
		this.value = aValue;
	}
	
	//---------------------------------
	//Enum Methods
	//---------------------------------
	
	/**
	 * Returns the string representation of a value
	 * 
	 * @return The string representation of a value
	 */
	@Override
	public String toString()
	{
		return this.value;
	}
	
}
