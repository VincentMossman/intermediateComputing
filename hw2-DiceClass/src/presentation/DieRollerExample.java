package presentation;

import java.util.ArrayList;
import gamecomponents.*;

public class DieRollerExample
{

    public static void main(String[] args)
    {
        Dice pairOfDice = new Dice();

        ArrayList<Die> someDice = new ArrayList<Die>();
        someDice.add(new Die(4));
        someDice.add(new Die(10));
        someDice.add(new Die(12));
        Dice threeDice = new Dice(someDice);

        Dice fourDice = new Dice(4);

        Dice fiveDice = new Dice(5, 10);

        System.out.println(pairOfDice.containsDice() + ": " + pairOfDice.roll());
        System.out.println(threeDice.containsDice() + ": " + threeDice.roll());
        System.out.println(fourDice.containsDice() + ": " + fourDice.roll());
        System.out.println(fiveDice.containsDice() + ": " + fiveDice.roll());
        
        fiveDice.add(new Die(20));
        System.out.println(fiveDice.containsDice() + ": " + fiveDice.roll());

    }

}
