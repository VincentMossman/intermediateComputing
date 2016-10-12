package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import playingcards.IPlayingCard;

@SuppressWarnings("serial")
public class CardPanel extends JPanel
{
    //Instance variables
    IPlayingCard card;
    
    //Constructor 
    public CardPanel()
    {
       
        this.setPreferredSize(new Dimension(125,175));
    }

    
    public void setCard(IPlayingCard aCard)
    {
        card = aCard;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (card == null)
        {
            this.setBackground(Color.lightGray);
        }
        else
        {
            this.setBackground(Color.white);
            g.drawString(card.toString(), 5, 75);           
        }

    }
    
}
