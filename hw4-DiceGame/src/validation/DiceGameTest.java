package validation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import gamecomponents.DiceGame;

/**
 * This class tests the playRound method of the DiceGame class,
 *  to ensure win ratio for Player/CPU is reasonably skewed
 * 
 * @author  Vincent T. Mossman
 * @version October 15, 2014 (v1.0)
 *
 */
public class DiceGameTest
{
	private DiceGame game1;
	
	@Before
	public void setUp() throws Exception
	{
		game1 = new DiceGame();
	}
	
	@After
	public void tearDown() throws Exception
	{
	}
	
	//---------------------------------
	//Tests
	//---------------------------------
	
	@Test
	public void testPlayRoundHIGH()
	{
		//Local Variables
		int numWins = 0;
		
		for (int i = 0; i < 1000; i++)
		{
			game1.playRound("HIGH");
			
			if (game1.isWinner())
			{
				numWins++;
			}
		}

		//Ensure player wins 19%-29% of the time when picking HIGH
		// (player wins 190 - 290 games per 1000)
		assertEquals(0.24, numWins / 1000.0, 0.05);
	}
	
	@Test
	public void testPlayRoundLOW()
	{
		//Local Variables
		int numWins = 0;
		
		for (int i = 0; i < 1000; i++)
		{
			game1.playRound("LOW");
			
			if (game1.isWinner())
			{
				numWins++;
			}
		}

		//Ensure player wins 19%-29% of the time when picking LOW
		// (player wins 190 - 290 games per 1000)
		assertEquals(0.24, numWins / 1000.0, 0.05);
	}
	
}
