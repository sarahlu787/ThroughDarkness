
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * The Wall class extends Actor and defiens the Wall object.
 * @author Sarah Lu, Ally Wang
 * @version 5/15/17
 *
 */
public class Wall extends Actor
{
	
	private Image wall;

	/**
	 * The constructor defines the image of the wall.
	 */
	public Wall() 
	{
		
		wall = new ImageIcon("black.jpg").getImage();
	}
	


	@Override
	/**
	 * The paint method draws the Wall.
	 * @param g the Graphics component
	 * @param x the x-coordinate of the Wall
	 * @param y the y-coordinate of the Wall
	 */
	public void paint(Graphics g, int x, int y) {
		g.drawImage(wall,x,y,GridPanel.GRID_SIZE,GridPanel.GRID_SIZE,null);
		
	}


}