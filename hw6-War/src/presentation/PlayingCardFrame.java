package presentation;

import playingcards.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class PlayingCardFrame extends JFrame
{
    
//Instance Variables
private CardPanel playerCard;
private DrawPilePanel playerDrawPile;
private CardPanel cpuCard;
private DrawPilePanel cpuDrawPile;
private JPanel menu;
private JPanel field;
private JLabel roundState = new JLabel("Click to Play!");

private WarGame game;

//Constructor
/**
 * Creates the frame with using the deck provided.
 * @param aDeck - the deck to use.Ga
 */
public PlayingCardFrame(IDeckOfCards aDeck)
{
	game = new WarGame(aDeck);
	
    this.setLayout(new FlowLayout());
    this.setSize(650, 300);
    this.setTitle("War");
    this.setBackground(Color.lightGray);
    
    this.createMenuPanel();
    this.fieldMenuPanel();
    this.add(menu);
    this.add(field);
    this.add(roundState);
}

//Helper Methods

private void createMenuPanel()
{
    menu = new JPanel();
    
    JButton resetButton = new JButton("Start a New Game");
    resetButton.addActionListener(new ResetListener());
    menu.add(resetButton);
}

private void fieldMenuPanel()
{
    field = new JPanel();
    
    playerCard = new CardPanel();
    playerDrawPile = new DrawPilePanel();
    playerDrawPile.addMouseListener(new DrawListener());
    
    cpuCard = new CardPanel();
    cpuDrawPile = new DrawPilePanel();
    
    field.add(new JLabel("Player"));
    field.add(playerDrawPile);
    field.add(playerCard);
    field.add(cpuCard);
    field.add(cpuDrawPile);
    field.add(new JLabel("CPU"));
}

class DrawListener implements MouseListener
{

    
    public void mouseClicked(MouseEvent e)
    {
    	game.PlayRound();
    	
        if (!game.GameOver())
        {
            playerCard.setCard(game.PlayerCardPlayed());
            cpuCard.setCard(game.CPUCardPlayed());
            
            if (game.PlayerWonPreviousRound())
            {
            	roundState.setText("You Win!");
            }
            else
            {
            	roundState.setText("You Lose!");
            }
        }
        else
        {
            if (game.CPUWonPreviousRound())
            {
            	roundState.setText("You Lost the Game!");
                playerDrawPile.setOutOfCards(true);
            }
            else
            {
            	roundState.setText("You Won the Game!");
            	cpuDrawPile.setOutOfCards(true);
            }
        }
        
        PlayingCardFrame.this.repaint();
    }

    
    public void mousePressed(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    
    public void mouseReleased(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    
    public void mouseEntered(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    
    public void mouseExited(MouseEvent e)
    {
        // TODO Auto-generated method stub
        
    }

}

class ResetListener implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        game.Reset();
        
        playerDrawPile.setOutOfCards(false);
        playerCard.setCard(null);
        cpuDrawPile.setOutOfCards(false);
        cpuCard.setCard(null);
        
        roundState.setText("Click to Play!");
        
        PlayingCardFrame.this.repaint();
    }
}
}