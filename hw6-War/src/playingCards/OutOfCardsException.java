package playingcards;
/** 
 * An exception that represents the fact that there are no more cards.
 * 
 * @author Michael J. Holmes
 * @version 1.0 October 1, 2012.
 */
@SuppressWarnings("serial")
public class OutOfCardsException extends Exception 
{
	//----------------------------------
	// Constructors
	//----------------------------------
	
	/**
	 * Default constructor to create an exception.
	 */
	public OutOfCardsException()
	{
		super();
	}
	
	/**
	 * Constructor that allows for a message to be included.
	 * 
	 * @param message text to include with the exception.
	 */
	public OutOfCardsException(String message)
	{
		super(message);
	}
	
}
