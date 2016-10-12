package playingcards;

public interface IDeckOfCards
{
/**
 * Removes the top card from the deck and returns it.
 * @return - The card drawn.
 */
    public IPlayingCard drawCard() throws OutOfCardsException;             
    
    /**
     * Adds a card to the existing deck.
     */
    public void add(IPlayingCard cardToAdd);  
    
    /**
     * Adds the array of cards to the deck.
     */
    public void add(IPlayingCard[] cardsToAdd);
    
    /**
     * Adds the cards form the inputed deck to the existing deck.
     */
    public void add(IDeckOfCards cardsToAdd);
    
    /**
     * Shuffles the deck.
     */
    public void shuffle();                       
    
    /**
     * Sorts the deck
     */
    public void sort();                          
/**
 * Deals out all of the cards from the deck into the number of hands passed in.
 * @param numOfHands - number of hands to deal
 * @return - array of hands.
 */
    public IHand[] dealCards(int numOfHands);
    
/**
 * Deals out all the number cards for the number of hands passed in.
 * @param numOfHands - Number of hand to deal.
 * @param numOfCards - Number of cards in each hand.
 * @return - array of hands.
 */
    public IHand[] dealCards(int numOfHands, int numOfCards) throws OutOfCardsException;
    
    
/**
 * Returns if the deck is empty.
 * @return - True if the deck is empty, false if it is not.
 */
    public boolean isEmpty();
    
    /**
     *  Resets the deck back to the original state when it was created. 
     */
    public void reset();
}
