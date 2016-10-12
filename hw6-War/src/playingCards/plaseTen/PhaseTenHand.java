package playingcards.phaseten;

import playingcards.IHand;

/** 
 * The PhaseTenHand class represents a hand of cards from the Phase Ten card game.
 * 
 * @author  Vincent T. Mossman (based on code written by Mike J. Holmes)
 * @version November 5, 2014 (v1.0)
 */

public class PhaseTenHand extends PhaseTenDeck implements IHand
{
	/**
	 * Compares to Phase Ten hands.
	 * 
	 * @param other the other hand to compare to.
	 * 
	 * @return 1 if the other hand is not a Phase Ten hand,
	 *         0 if it is a Phase Ten hand.
	 */
	public int compareTo(IHand other) 
	{
		if (this.getClass() != other.getClass())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}
