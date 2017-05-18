import java.awt.Color;
import java.awt.Graphics;

import ally.shapes.Line;

/**
 * The Direction class displays the direction as an arrow from the character to the exit.
 * @author Sarah Lu, Ally Wang
 * @version 5/15/17
 *
 */

public class Direction
{
	private double direction; 

	public Direction() 
	{
		direction = 0;
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
	public void paint(Graphics g, double degree, int rows)
	{
		int size = GridPanel.GRID_SIZE;
		int height = rows*size;
		g.setColor(Color.BLACK);
		double x2 = Math.sin(degree)*size*3;
		double y2 = Math.cos(degree)*size*3;
		
		
		g.setColor(Color.white);
		g.fillRect(650, 0, 150, 150);
		
		g.setColor(Color.BLACK);
		//g.drawLine(size*3,height-size*3, size*3+(int)x2, height-size*3+(int)y2);
		g.drawLine(700,75, 700+(int)x2, 75+(int)y2);
		g.fillOval(700+(int)x2-10, 75+(int)y2-10, 20,20);
		

		
		
		
		
		
		//g.drawOval(size*3+(int)x2, height-size*3+(int)y2, 20, 20);
		//int x = size*3+(int)(Math.sin(degree)*size*4);
		//int y = height-size*3+(int)(Math.cos(degree)*size*4);
		
		
	}
	

}
