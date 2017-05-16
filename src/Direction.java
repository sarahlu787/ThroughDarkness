import java.awt.Color;
import java.awt.Graphics;

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
		
		return direction;
	}

	/**
	 * The paint method draws the direction on the screen.
	 */
	public void paint(Graphics g, double degree)
	{
		g.setColor(Color.BLACK);
		double x2 = Math.sin(degree)*200;
		double y2 = Math.cos(degree)*200;
		g.drawLine(300,300, 300+(int)x2, 300+(int)y2);
		g.drawOval(300+(int)x2, 300+(int)y2, 20, 20);
	}

}
