package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawPilePanel extends JPanel
{

    //IV
    private boolean more;
    
    //Constructor 
    public DrawPilePanel()
    {
        more = true;
        this.setPreferredSize(new Dimension(125,175));
    }
    
    public void setOutOfCards(boolean value)
    {
        more = !value;
    }
    
    public void paintComponent(Graphics g)
    {
        if (more)
            this.setBackground(Color.blue);
        else
            this.setBackground(Color.lightGray);
        
        super.paintComponent(g);
    }

}
