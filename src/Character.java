import java.awt.Graphics;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;


public class Character extends Actor
{
	private Location location;
	
	
	
	public Character(int row, int col) 
	{
		location = new Location(row,col);
	}
	
	public void moveLeft()
	{
		
	}
	
	public void moveRight()
	{
		
	}
	
	public void moveUp()
	{
		
	}
	
	public void moveDown()
	{
		
	}
	
	public boolean canMove() {
		Grid<Actor> gr = getGrid();
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(getDirection());
		Actor neighbor = gr.get(next);
		return (neighbor==null);
	}
	
	
	
	
	
	// returns the current position of the character
	// might have to make a package like what we did in GridWorld?
	public Location getCurrentPosition(){

		return location;
	}

	@Override
	public void paint(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}


}