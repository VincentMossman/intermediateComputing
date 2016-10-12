package playingcards.phaseten;

import java.util.ArrayList;
import java.util.Collections;

import playingcards.IDeckOfCards;
import playingcards.IHand;
import playingcards.IPlayingCard;
import playingcards.OutOfCardsException;

/** 
 * The PhaseTenDeck class represents a deck from the Phase Ten card game.
 * 
 * @author  Vincent T. Mossman (based on code written by Mike J. Holmes)
 * @version November 5, 2014 (v1.0)
 */

public class PhaseTenDeck implements IDeckOfCards
{
	
	//-----------------------------------------
	// Instance Variables
	//-----------------------------------------
	
	private ArrayList<IPlayingCard> myCards;
	
	//-----------------------------------------
	// Constructors
	//-----------------------------------------	
	
	/**
	 * Default constructor that creates a standard Phase Ten deck.
	 */
	public PhaseTenDeck()
	{
		this.reset();
	}
	
	//-----------------------------------------
	// Class Methods
	//-----------------------------------------
	
	/**
	 * Returns the top card from the deck.  If there are no cards left in the deck
	 * it will throw an OutOfCardsException.
	 * 
	 * @throws OutOfCardsException if the deck is empty.
	 * 
	 * @return The top card of the deck.
	 */
	public IPlayingCard drawCard() throws OutOfCardsException 
	{
		IPlayingCard cardToReturn;
		
		if (isEmpty())
		{
			throw new OutOfCardsException();
		}
		else
		{
			cardToReturn = myCards.get(0);
			myCards.remove(0);
		}

		return cardToReturn;
	}
	
	/**
	 * Adds a card to the existing deck.
	 * 
	 * @param The playing card to add.
	 */
	public void add(IPlayingCard cardToAdd) 
	{
		myCards.add(cardToAdd);
	}
	
	/**
	 * Adds an array of cards to the existing deck.
	 * 
	 * @param The playing cards to add.
	 */
	public void add(IPlayingCard[] cardsToAdd) 
	{
		for(IPlayingCard aCard : cardsToAdd)
		{
			myCards.add(aCard);
		}
	}
	
	/**
	 * Adds the contents of another deck to the existing deck.
	 * 
	 * @param the deck of cards to add.
	 */
	public void add(IDeckOfCards cardsToAdd) 
	{
		while (!cardsToAdd.isEmpty())
		{
			try 
			{
				myCards.add(cardsToAdd.drawCard());
			} 
			catch (OutOfCardsException e) 
			{
				//Ignore exception.  While condition prevents it.
			}
		}
	}
	
	/**
	 *  Shuffles the deck to a random order. 
	 */
	public void shuffle() 
	{
		Collections.shuffle(myCards);
	}
	
	/**
	 * Sorts the deck of cards.
	 */
	public void sort() 
	{
		Collections.sort(myCards);
	}
	
	/**
	 * Deals out all of the cards in the deck to the inputed number of hands.
	 * 
	 * @return an array of Hand objects containing the dealt cards.
	 */
	public IHand[] dealCards(int numOfHands) 
	{
		IHand[] handsToReturn = new IHand[numOfHands];
		
		for (int i=0; i < numOfHands; i++)
		{
			handsToReturn[i] = new PhaseTenHand();
		}
		
		int hand = 0;
		
		while(true)
		{
			try 
			{
				handsToReturn[hand].add(this.drawCard());
				
				hand++;
				if (hand >= numOfHands)
				{
					hand = 0;
				}
			} 
			catch (OutOfCardsException e) 
			{
				//Out of cards.  Stop dealing.
				break;
			}
		}
		
		return handsToReturn;
	}
	
	/**
	 * Deals out all of the cards in the deck to the inputed number of hands,
	 * with a given number of cards in each hand.
	 *
	 * @throws OutOfCardsException if there are not enough cards in the deck to deal.
	 * 
	 * @return an array of Hand objects containing the dealt cards.
	 */
	public IHand[] dealCards(int numOfHands, int numOfCards) throws OutOfCardsException 
	{
		IHand[] handsToReturn = new IHand[numOfHands];
		
		for (int i=0; i < numOfHands; i++)
		{
			handsToReturn[i] = new PhaseTenHand();
		}
		
		for(int i = 0; i < numOfCards; i++)
		{
			for(int j = 0; j < numOfHands; j++)
			try 
			{
				handsToReturn[j].add(this.drawCard());
			} 
			catch (OutOfCardsException e) 
			{
				throw e;
			}
		}
		
		return handsToReturn;
	}
	
	/**
	 * Checks if the deck is empty.
	 * 
	 * @return true if the deck is empty, false if it is not.
	 */
	public boolean isEmpty() 
	{
		return myCards.size() == 0;
	}
	
	/**
	 * Resets the deck to its initial state.
	 */
	public void reset() 
	{
		myCards = new ArrayList<IPlayingCard>();
		
		PhaseTenCardSuit[]  suits  = PhaseTenCardSuit.values();
		PhaseTenCardValue[] values = PhaseTenCardValue.values();
		
		//Add all numbered cards by suit
		for (int i = 0; i < 2; i++)
		{
			for (int n = 0; n < values.length - 2; n++)
			{
				//Add all cards besides Wild and Skip
				for (int m = 0; m < suits.length; m++)
				{
					myCards.add(new PhaseTenCard(suits[m], values[n]));
				}
			}
		}
		
		//Add Wild cards
		for (int i = 0; i < 2; i++)
		{
			for (int n = 0; n < suits.length; n++)
			{
				myCards.add(new PhaseTenCard(suits[n], PhaseTenCardValue.WILD));
			}
		}
		
		//Add Skip Cards
		for (int n = 0; n < suits.length; n++)
		{
			myCards.add(new PhaseTenCard(suits[n], PhaseTenCardValue.SKIP));
		}
		
		this.sort();
	}

}
