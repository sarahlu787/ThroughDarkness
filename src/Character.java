
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import info.gridworld.grid.Location;

/**
 * The Character class extends Actor defines the character.
 * @author Sarah Lu, Ally Wang
 * @version 5/15/17
 *
 */
public class Character extends Actor
{
	
	private Image image;
	
	/**
	 * The constructor sets the Character's image.
	 */
	public Character() 
	{
		image = new ImageIcon("character.jpg").getImage();
	}
	
	/**
	 * The move method defines the movement of the Character.
	 */
	public void move() {
		if (canMove())
		    moveTo(getLocation().getAdjacentLocation(getDirection()));
	}
	
	
	/**
	 * The moveLeft method moves the Character left.
	 */
	public void moveLeft()
	{
		setDirection(Location.WEST);
		move();
	}
	
	/**
	 * The moveRight method moves the Character right.
	 */
	public void moveRight()
	{
		setDirection(Location.EAST);
		move();
	}
	
	/**
	 * The moveUp method moves the Character up.
	 */
	public void moveUp()
	{
		setDirection(Location.NORTH);
		move();
	}
	
	/**
	 * The moveDown method moves the Character down.
	 */
	public void moveDown()
	{
		setDirection(Location.SOUTH);
		
		move();
	}
	
	
	/**
	 * The canMove method determines if the Character can move in its current direction.		
	 * @return true if the Character can move, false otherwise
	 */
	public boolean canMove() {
		Grid gr = getGrid();
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if(!gr.isValid(next))
			return false;
		return (gr.get(next) == null);
	}
	
	/**
	 * The getRow method returns y-coordinate of the Character
	 * @return the y-coordinate of the Character as an integer
	 */
	public int getRow() {
		return getLocation().getRow();
	}
	
	/**
	 * The getRow method returns x-coordinate of the Character
	 * @return the x-coordinate of the Character as an integer
	 */
	public int getCol() {
		return getLocation().getCol();
	}
	


	
	@Override
	/**
	 * The paint method draws the Character
	 * @param g the Graphics component
	 * @param x the x-coordinate of the Character
	 * @param y the y-coordinate of the Character
	 */
	public void paint(Graphics g, int x, int y) {
		g.setColor(Color.black);
		g.drawOval(x-40, y-40, 96, 96);
		//g.fillOval(x-32, y-32, 80, 80);
		//g.fillArc(x-32, y-32, 80, 80, 0, 360);
		//g.drawArc(x-32, y-32, 80, 80, 0, 360);
		
		g.drawImage(image,x,y,GridPanel.GRID_SIZE,GridPanel.GRID_SIZE,null);
		
	}


}