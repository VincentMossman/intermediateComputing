package adapter;

/**
 * NOTICE: This code is incomplete, and likely will remain that way until the end of
 *  fucking time. So, get over it.
 *  
 * @author Vinny Mossman
 *
 */

public class SnakeAdapter2 extends Snake implements IAnimal
{
	public SnakeAdapter2(String aName)
	{
		super(aName);
	}
	
	public String speak()
	{
		return super.hiss();
	}
	
	public String move()
	{
		return super.slither();
	}
	
	//getName method already implemented.
}
