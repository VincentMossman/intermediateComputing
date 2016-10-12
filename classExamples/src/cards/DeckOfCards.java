import java.util.ArrayList; //Import for collection of cards

public class DeckOfCards {
	
	//Instance Variables
	private int numCards;
	//<DEL>\\ private PlayingCard[] myCards; //[] = array
	private ArrayList<PlayingCard> myCards;
	
	
	public PlayingCard draw()
	{
		//Local variable
		PlayingCard temp = myCards.get(0);
		myCards.remove(0);
		return temp; //Returns the top card after removing it
	}
}
