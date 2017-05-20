
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import info.gridworld.grid.Location;


/**
 * The Exit class defines and draws the Exit of the maze.
 * @author Sarah Lu, Ally Wang
 * @version 5/15/17
 *
 */
public class Exit extends Actor
{

	private Image exit;
	private Location location;
	
	/**
	 * The constructor defines the image of the exit.
	 */
	public Exit()
	{
		exit = new ImageIcon("exit.jpg").getImage();
	}
	



	@Override
	/**
	 * The paint method draws the Wall.
	 * @param g the Graphics component
	 * @param x the x-coordinate of the Wall
	 * @param y the y-coordinate of the Wall
	 */
	public void paint(Graphics g, int x, int y) {
		g.drawImage(exit,x,y,GridPanel.GRID_SIZE,GridPanel.GRID_SIZE,null);
		
	}



	/**
	 * The getRow method returns the y-coordinate of the exit.
	 * @return the y-coordinate of the exit
	 */
	public int getRow() {
		return getLocation().getRow();
	}
	
	/**
	 * The getCol method returns the x-coordinate of the exit.
	 * @return the x-coordinate of the exit
	 */
	public int getCol() {
		return getLocation().getCol();
	}
	

}