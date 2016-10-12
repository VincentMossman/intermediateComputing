package presentation;

import playingcards.phaseten.PhaseTenDeck;

public class GameApp
{

    public static void main(String[] args)
    {
        
        PlayingCardFrame myFrame = new PlayingCardFrame(new PhaseTenDeck());
        
        myFrame.setVisible(true);
        
    }

}
