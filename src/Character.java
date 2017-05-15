
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import info.gridworld.grid.Location;


public class Character extends Actor
{
	private Image image;
	
	
	public Character() 
	{
		image = new ImageIcon("character.jpg").getImage();
	}
	
	public void move() {
		//System.out.println(canMove());
		if (canMove())
		    moveTo(getLocation().getAdjacentLocation(getDirection()));
	}
	
	
	
	public void moveLeft()
	{
		setDirection(Location.WEST);
		move();
	}
	
	public void moveRight()
	{
		setDirection(Location.EAST);
		move();
	}
	
	public void moveUp()
	{
		setDirection(Location.NORTH);
		move();
	}
	
	public void moveDown()
	{
		setDirection(Location.SOUTH);
		
		move();
	}
	
	public boolean canMove() {
		Grid gr = getGrid();
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		if(!gr.isValid(next))
			return false;
		return gr.get(next) == null;
	}
	
	public int getRow() {
		return getLocation().getRow();
	}
	
	public int getCol() {
		return getLocation().getCol();
	}
	


	
	@Override
	public void paint(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		//g.fillOval(x-32, y-32, 80, 80);
		g.drawArc(x-32, y-32, 80, 80, 0, 360);
		
		g.drawImage(image,x,y,GridPanel.GRID_SIZE,GridPanel.GRID_SIZE,null);
		
	}


}
