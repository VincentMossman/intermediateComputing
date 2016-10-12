package playingcards.phaseten;

import playingcards.IPlayingCard;

/** 
 * The PhaseTenCard class represents a card from the Phase Ten card game.
 * 
 * @author  Vincent T. Mossman (based on code written by Mike J. Holmes)
 * @version November 5, 2014 (v1.0)
 */

public class PhaseTenCard implements IPlayingCard 
{
	
	//------------------------------------------
	// Instance Variables
	//------------------------------------------
	
	private PhaseTenCardSuit  suit;
	private PhaseTenCardValue value;
	
	//------------------------------------------
	// Constructors
	//------------------------------------------
	
	/**
	 * Constructs a Phase Ten playing card.  Requires values from the Phase Ten enums.
	 * 
	 * @param theSuit the PhaseTenCardColor representing the suit of the card.
	 * @param theValue the PhaseTenCardValue representing the value of the card.
	 */
	public PhaseTenCard(PhaseTenCardSuit theSuit, PhaseTenCardValue theValue)
	{
		suit  = theSuit;
		value = theValue;
	}
	
	//------------------------------------------
	// Class Methods
	//------------------------------------------
	
	/**
	 * Compares the Phase Ten card to another card. 
	 * If the other card is not a Phase Ten card -1 will be returned.
	 * If they are the same Phase Ten card a 0 will be returned.
	 * If it is less than the other Phase Ten card a -1 will be returned.
	 * If it is greater than the other Phase Ten card a 1 will be returned.
	 * 
	 * @param other The other playing card to compare it to.
	 */
	public int compareTo(IPlayingCard other) 
	{
		PhaseTenCard otherCard;
		
		//Check to see if the other card is an instance of PhaseTenCard.
		if(this.getClass() != other.getClass())
		{
			return -1;
		}
		else
		{
			//The other card is a PhaseTenCard, so recast it as one.
			otherCard = (PhaseTenCard) other;
			return compareValue(otherCard);
		}	
	}
	
	/**
	 * Returns a string representation of the card's suit and value.
	 * 
	 * @return The string representation of the Phase Ten card.
	 */
	@Override
	public String toString()
	{
		return suit.toString() + " " + value.toString();
	}
	
	/**
	 * Private helper method to compare this card's color to an other Phase Ten card's color.
	 *
	 * @param otherCard the PhaseTenCard to compare it to.
	 * @return 0 if they are the same color, -1 if this color is less than the other,
	 *           and 1 if this color is greater.
	 */
	@SuppressWarnings("unused")
	private int compareSuit(PhaseTenCard otherCard)
	{
		if (this.suit.ordinal() == otherCard.suit.ordinal())
		{
			return 0;
		}
		else if (this.suit.ordinal() < otherCard.suit.ordinal())
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
	/**
	 * Private helper method to compare this card's value to an other Phase Ten card's value.
	 *
	 * @param otherCard the PhaseTenCard to compare it to.
	 * @return 0 if they are the same value, -1 if this value is less than the other,
	 *           and 1 if this value is greater.
	 */
	private int compareValue(PhaseTenCard otherCard)
	{
		if (this.value.ordinal() == otherCard.value.ordinal())
		{
			return 0;
		}
		else if (this.value.ordinal() < otherCard.value.ordinal())
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
}
