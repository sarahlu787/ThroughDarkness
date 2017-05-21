import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;


/**
 * The Direction class displays the direction as an arrow from the character to the exit.
 * @author Sarah Lu, Ally Wang
 * @version 5/15/17
 *
 */

public class Direction
{
	private double direction; 
	private Image up, down, left, right, ul, ur, dl, dr;

	public Direction() 
	{
		direction = 0;
		
		up = new ImageIcon("up.png").getImage();
		down = new ImageIcon("down.png").getImage();
		left = new ImageIcon("left.png").getImage();
		right = new ImageIcon("right.png").getImage();
		ul = new ImageIcon("upleft.png").getImage();
		ur = new ImageIcon("upright.png").getImage();
		dl = new ImageIcon("downleft.png").getImage();
		dr = new ImageIcon("downright.png").getImage();
		
	}
	
	
	/**
	 * The getDirection method finds the direction from the Character to the Exit.
	 * @param c the Character object
	 * @param e the Exit object
	 */
	public double getDirection(Character c, Exit e)
	{
		
		int y = e.getRow()-c.getRow();
		int x = e.getCol()-c.getCol();
		double z = Math.sqrt(y*y+x*x);
		direction = Math.acos(y/z);
		if (e.getCol()<c.getCol())
		{
			direction = direction*-1;
		}
		return direction;
	}

	/**
	 * The paint method draws the direction on the screen.
	 */
	public void paint(Graphics g, double theta)
	{
		int size = GridPanel.GRID_SIZE;
		g.setColor(Color.BLACK);
		double x2 = Math.sin(theta)*size*3;
		double y2 = Math.cos(theta)*size*3;
		
		
		
	
		
		

		
		g.setColor(Color.white);
		g.fillRect(650, 0, 150, 150);
		
		g.setColor(Color.BLACK);
		
		g.drawLine(700,75, 700+(int)x2, 75+(int)y2);
		g.fillOval(700+(int)x2-10, 75+(int)y2-10, 20,20);
		

		Graphics2D g2d = (Graphics2D) g;

		g2d.translate(700, 75);
		g2d.rotate(theta);
		
		g2d.drawLine(0, 0, 100, 0);
		
		g2d.rotate(-theta);
		g2d.translate(-700, -75);

		
		
		//g.drawOval(size*3+(int)x2, height-size*3+(int)y2, 20, 20);
		//int x = size*3+(int)(Math.sin(degree)*size*4);
		//int y = height-size*3+(int)(Math.cos(degree)*size*4);
		
		
	}
	

}
