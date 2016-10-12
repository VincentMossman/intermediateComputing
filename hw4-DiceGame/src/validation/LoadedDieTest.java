package validation;

import gamecomponents.LoadedDie;
import java.util.Random;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

/**
 * This class tests the roll method (and subsequently the constructors) of 
 *  the LoadedDie class.
 * 
 * @author  Vincent T. Mossman
 * @version October 15, 2014 (v1.0)
 *
 */

public class LoadedDieTest
{
	private LoadedDie die1;
	private LoadedDie die2;
	private LoadedDie die3;
	private LoadedDie die4;
	private Random myRandomNumGenerator = new Random(); //Used for arbitrary, but specific,
														// non-loaded value
	
	@Before
	public void setUp() throws Exception
	{
		die1 = new LoadedDie(); //Default Die
		die2 = new LoadedDie(10, 10, 0.5); //Reasonable Die
		die3 = new LoadedDie(9001, 5, 0.9); //Ridiculous Die (Over 9000, Dragon Ball Z reference)
		die4 = new LoadedDie(2, 1, 0.3); //Basically a coin
	}
	
	@After
	public void tearDown() throws Exception
	{
	}
	
	//---------------------------------
	//Tests
	//---------------------------------
	
		//Test loaded value
		//---------------------------------
	
	@Test
	public void testRollDefaultConstructor()
	{
		//Local Variables
		int numLoadedRolls = 0;
		
		//Roll Die
		for (int i = 0; i < 10000; i++)
		{
			if (die1.roll() == 6)
			{
				numLoadedRolls++;
			}
		}

		//Ensure percentage of 10,000 rolls is loaded with accuracy
		// within 1% of loaded percentage
		assertEquals(0.9, numLoadedRolls / 10000.0, 0.01);
	}
	
	@Test
	public void testRollReasonableDie()
	{
		//Local Variables
		int numLoadedRolls = 0;
		
		//Roll Die
		for (int i = 0; i < 10000; i++)
		{
			if (die2.roll() == 10)
			{
				numLoadedRolls++;
			}
		}

		//Ensure percentage of 10,000 rolls is loaded with accuracy
		// within 1% of loaded percentage
		assertEquals(0.5, numLoadedRolls / 10000.0, 0.01);
	}
	
	@Test
	public void testRollRidiculousDie()
	{
		//Local Variables
		int numLoadedRolls = 0;
		
		//Roll Die
		for (int i = 0; i < 10000; i++)
		{
			if (die3.roll() == 5)
			{
				numLoadedRolls++;
			}
		}

		//Ensure percentage of 10,000 rolls is loaded with accuracy
		// within 1% of loaded percentage
		assertEquals(0.9, numLoadedRolls / 10000.0, 0.01);
	}
	
	@Test
	public void testRollCoin()
	{
		//Local Variables
		int numLoadedRolls = 0;
		
		//Roll Die (or Flip Coin, whichever you prefer)
		for (int i = 0; i < 10000; i++)
		{
			if (die4.roll() == 1)
			{
				numLoadedRolls++;
			}
		}

		//Ensure percentage of 10,000 rolls is loaded with accuracy
		// within 1% of loaded percentage
		assertEquals(0.3, numLoadedRolls / 10000.0, 0.01);
	}
	
		//Test non-loaded value
		//---------------------------------
	
	@Test
	public void testRollDefaultConstructorNonLoaded()
	{
		//Local Variables
		int numLoadedRolls = 0;
		int nonLoadedValue = 6; //Initialize to loaded value so we can
								// make it not that
		
		//Initialize nonLoadedValue
		while (nonLoadedValue == 6)
		{
			nonLoadedValue = myRandomNumGenerator.nextInt(6) + 1;
		}
		
		//Roll Die
		for (int i = 0; i < 10000; i++)
		{
			if (die1.roll() == nonLoadedValue)
			{
				numLoadedRolls++;
			}
		}

		//Ensure arbitrary, but specific, non-loaded value of 10,000 rolls
		// has accuracy within 1% of non-loaded percentage
		assertEquals((1.0 - 0.9) / 5, numLoadedRolls / 10000.0, 0.01);
	}
	
	@Test
	public void testRollReasonableDieNonLoaded()
	{
		//Local Variables
		int numLoadedRolls = 0;
		int nonLoadedValue = 10; //Initialize to loaded value so we can
								// make it not that
		
		//Initialize nonLoadedValue
		while (nonLoadedValue == 10)
		{
			nonLoadedValue = myRandomNumGenerator.nextInt(10) + 1;
		}
		
		//Roll Die
		for (int i = 0; i < 10000; i++)
		{
			if (die2.roll() == nonLoadedValue)
			{
				numLoadedRolls++;
			}
		}

		//Ensure arbitrary, but specific, non-loaded value of 10,000 rolls
		// has accuracy within 1% of non-loaded percentage
		assertEquals((1.0 - 0.5) / 9, numLoadedRolls / 10000.0, 0.01);
	}
	
	@Test
	public void testRollRidiculousDieNonLoaded()
	{
		//Local Variables
		int numLoadedRolls = 0;
		int nonLoadedValue = 5; //Initialize to loaded value so we can
								// make it not that
		
		//Initialize nonLoadedValue
		while (nonLoadedValue == 5)
		{
			nonLoadedValue = myRandomNumGenerator.nextInt(9001) + 1;
		}
		
		//Roll Die
		for (int i = 0; i < 10000; i++)
		{
			if (die3.roll() == nonLoadedValue)
			{
				numLoadedRolls++;
			}
		}

		//Ensure arbitrary, but specific, non-loaded value of 10,000 rolls
		// has accuracy within 1% of non-loaded percentage
		assertEquals((1.0 - 0.9) / 9000, numLoadedRolls / 10000.0, 0.01);
	}
	
	@Test
	public void testRollCoinNonLoaded()
	{
		//Local Variables
		int numLoadedRolls = 0;
		int nonLoadedValue = 1; //Initialize to loaded value so we can
								// make it not that
		
		//Initialize nonLoadedValue
		while (nonLoadedValue == 1)
		{
			nonLoadedValue = myRandomNumGenerator.nextInt(2) + 1;
		}
		
		//Roll Die (or Flip Coin, whichever you prefer)
		for (int i = 0; i < 10000; i++)
		{
			if (die4.roll() == nonLoadedValue)
			{
				numLoadedRolls++;
			}
		}

		//Ensure arbitrary, but specific, non-loaded value of 10,000 rolls
		// has accuracy within 1% of non-loaded percentage
		assertEquals((1.0 - 0.3) / 1, numLoadedRolls / 10000.0, 0.01);
	}

}
