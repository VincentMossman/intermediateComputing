package adapter;

/**
 * NOTICE: This code is incomplete, and likely will remain that way until the end of
 *  fucking time. So, get over it.
 *  
 * @author Vinny Mossman
 *
 */

public class SnakeAdapter implements IAnimal
{
	//Instance Variables
	Snake aSnake;
	
	//Default Constructor
	public SnakeAdapter(String aName)
	{
		this.aSnake = new Snake(aName);
	}
	
	//Methods
	public String speak()
	{
		return this.aSnake.hiss();
	}
	
	public String getName()
	{
		return this.aSnake.getName();
	}
	
	public String move()
	{
		return this.aSnake.slither();
	}
}
