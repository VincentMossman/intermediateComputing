package playingcards.phaseten;

/** 
 * PhaseTenCardSuit is an enumeration that contains all the valid values for a
 *  suit of a PhaseTenCard: Red, Orange, Yellow, and Green. It also includes a 
 *  toString method.
 * 
 * @author  Vincent T. Mossman (based on code written by Mike J. Holmes)
 * @version November 5, 2014 (v1.0)
 */

public enum PhaseTenCardSuit
{
	//---------------------------------
	//Phase Ten Card Suits
	//---------------------------------
		
	RED("Red"), ORANGE("Orange"), YELLOW("Yellow"), GREEN("Green");
	
	//---------------------------------
	//Instance Variables
	//---------------------------------
	
	private String suit;
	
	//---------------------------------
	//Constructors
	//---------------------------------
	
	/**
	 * Constructs a suit that stores the string representation of that suit
	 * 
	 * @param aSuit String representation of a suit
	 */
	private PhaseTenCardSuit(String aSuit)
	{
		 this.suit = aSuit;
	}
	
	//---------------------------------
	//Enum Methods
	//---------------------------------
	
	/**
	 * Returns the string representation of a suit
	 * 
	 * @return The string representation of a suit
	 */
	@Override
	public String toString()
	{
		return this.suit;
	}
	
}
