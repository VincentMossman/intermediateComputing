
public class PlayingCard {
	
	//Instance Variables
	private String cardValue;
	private String cardSuit;
	
	//Constructors
		//Default constructor
	public PlayingCard()
	{
		cardValue = "King";
		cardSuit  = "Hearts";
	}
	
	public PlayingCard(String aValue, String aSuit)
	{
		cardValue = aValue;
		cardSuit  = aSuit;
	}
	
	//Class Methods
	public String displayCard()
	{
		return cardValue + " of " + cardSuit;
	}
	
	//Piss on this fuckass
}
