package presentation;

import playingcards.*;

/** 
 * The WarGame class simulates a game of War (with cards, not human life).
 * 
 * @author  Vincent T. Mossman
 * @version November 6, 2014 (v1.0)
 */

public class WarGame
{
	
	//-----------------------------------------
	// Instance Variables
	//-----------------------------------------
	
	private enum State
	{
		WIN, DRAW, LOSE;
	}
	
	private IDeckOfCards   theDeck;
	private IHand[]		   hands;
	private IPlayingCard[] cardsPlayed;
	private IDeckOfCards   tieDeck;
	private boolean		   gameOver;
	private State		   playerState;
	
	//-----------------------------------------
	// Constructors
	//-----------------------------------------
	
	public WarGame(IDeckOfCards aDeck)
	{
		this.theDeck  = aDeck;
		this.hands    = this.theDeck.dealCards(2); //0 = player, 1 = CPU
		this.hands[0].shuffle();
		this.hands[1].shuffle();
		this.cardsPlayed = new IPlayingCard[2];
		
		//Create empty tieDeck
		this.tieDeck = aDeck;
		while (!this.tieDeck.isEmpty())
		{
			this.tieDeck.dealCards(1);
		}
		
		this.gameOver	 = false;
		this.playerState = State.DRAW;
	}
	
	//-----------------------------------------
	// Class Methods
	//-----------------------------------------
	
	public void PlayRound()
	{
		//Shuffle hands before each round
		this.hands[0].shuffle();
		this.hands[1].shuffle();
		
		try
		{
			this.cardsPlayed[0] = this.hands[0].drawCard();
			this.cardsPlayed[1] = this.hands[1].drawCard();
			
			if (this.cardsPlayed[0].compareTo(this.cardsPlayed[1]) == 0)
			{
				this.playerState = State.DRAW;
				this.tieDeck.add(this.cardsPlayed);
				this.tieDeck.add(this.hands[0].drawCard());
				this.tieDeck.add(this.hands[1].drawCard());
				this.PlayRound();
			}
			else if (this.cardsPlayed[0].compareTo(this.cardsPlayed[1]) == 1)
			{
				this.playerState = State.WIN;
				this.hands[0].add(this.cardsPlayed);
			}
			else
			{
				this.playerState = State.LOSE;
				this.hands[1].add(this.cardsPlayed);
			}
		} 
		catch (OutOfCardsException e) 
		{
			this.gameOver = true;
		}
	}
	
	public boolean PlayerWonPreviousRound()
	{
		return this.playerState == State.WIN;
	}
	
	public boolean CPUWonPreviousRound()
	{
		return this.playerState == State.LOSE;
	}
	
	public IPlayingCard PlayerCardPlayed()
	{
		return this.cardsPlayed[0];
	}
	
	public IPlayingCard CPUCardPlayed()
	{
		return this.cardsPlayed[1];
	}
	
	public boolean GameOver()
	{
		return this.gameOver;
	}
	
	public void Reset()
	{
		//Put cards back in deck
		this.theDeck.add(this.hands[0]);
		this.theDeck.add(this.hands[1]);
		this.hands    = this.theDeck.dealCards(2); //0 = player, 1 = CPU
		this.hands[0].shuffle();
		this.hands[1].shuffle();
		this.cardsPlayed = new IPlayingCard[2];
		
		//Create empty tieDeck
		this.tieDeck = theDeck;
		while (!this.tieDeck.isEmpty())
		{
			this.tieDeck.dealCards(1);
		}
		
		this.gameOver	 = false;
		this.playerState = State.DRAW;
	}

}
