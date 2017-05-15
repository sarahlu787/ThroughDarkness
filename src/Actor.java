import java.awt.Color;
import java.awt.Graphics;

import info.gridworld.grid.Location;


//Actor Class

public abstract class Actor 
{
	private Grid grid;
	private Location location;
	private int direction;
	private Color color;
	
	public Actor() {
		//color = Color.BLACK;
		//grid = null;

		location = null;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color newColor) {
		color = newColor;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int newDirection) {
		direction = newDirection;
	}
	
    public Grid getGrid()
    {
        return grid;
    }	
    
    public Location getLocation()
    {
        return location;
    }
	

	public void moveTo(Location newLocation)
    {
        if (grid == null)
            throw new IllegalStateException("This actor is not in a grid.");
        if (grid.get(location) != this)
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + location + ".");
        if (!grid.isValid(newLocation))
            throw new IllegalArgumentException("Location " + newLocation
                    + " is not valid.");

        if (newLocation.equals(location))
            return;
        grid.remove(location);
        Actor other = grid.get(newLocation);
        if (other != null)
            other.removeSelfFromGrid();
        location = newLocation;
        grid.put(location, this);
    }
	
	
	public void removeSelfFromGrid()
    {
        if (grid == null)
            throw new IllegalStateException(
                    "This actor is not contained in a grid.");
        if (grid.get(location) != this)
            throw new IllegalStateException(
                    "The grid contains a different actor at location "
                            + location + ".");

        grid.remove(location);
        grid = null;
        location = null;
    }
	
    public void putSelfInGrid(Grid gr, Location loc)
    {
        if (grid != null)
            throw new IllegalStateException(
                    "This actor is already contained in a grid.");

        Actor actor = gr.get(loc);
        if (actor != null)
            actor.removeSelfFromGrid();
        gr.put(loc, this);
        grid = gr;
        location = loc;
    }

	
	/*
	public Grid<Actor> getGrid() {
		return grid;
	}
	*/
	
	public void act() {
		
	}
	
	public abstract void paint(Graphics g, int x, int y);
	
	public String toString() {
		return getClass().getName() + "[location=" + location + ",direction="
                + direction +  "]";
	}
	
	
}