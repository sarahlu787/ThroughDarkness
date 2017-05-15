import java.awt.Color;
import java.awt.Graphics;

import info.gridworld.grid.Location;


//Actor Class
/**
 * 
 * @author Sarah Lu, Ally Wang
 * @version 5/15/17
 * This is an abstract Actor class that defines the basics for an actor in the grid.
 *
 */
public abstract class Actor 
{
	private Grid grid;
	private Location location;
	private int direction;
	//private Color color;
	
	/**
	 * The constructor for Actor initializes its location to null.
	 */
	public Actor() {
		//color = Color.BLACK;
		//grid = null;

		location = null;
	}
	
	/*public Color getColor() {
		return color;
	}*/
	
	/*public void setColor(Color newColor) {
		color = newColor;
	}*/
	
	/**
	 * The getDirection method returns the direction of the Actor's movement.
	 * @return the direction as an integer
	 */
	public int getDirection() {
		return direction;
	}
	
	/**
	 * The setDirection method sets the direction of the Actor's movement.
	 * @param newDirection the new direction as an integer
	 */
	public void setDirection(int newDirection) {
		direction = newDirection;
	}
	
	/**
	 * The getGrid method returns the current grid.
	 * @return the current grid
	 */
    public Grid getGrid()
    {
        return grid;
    }	
    
    /**
     * The get Location method returns the location of the Actor.
     * @return the location of the Actor
     */
    public Location getLocation()
    {
        return location;
    }
	

    /**
     * The moveTo method moves the Actor to a new location.
     * @param newLocation the new location of the Actor
     */
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
	
	/**
	 * The removeSelfFromGrid removes the current Actor from the grid.
	 */
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
	
	/**
	 * The putSelfInGrid puts the Actor in a specified grid in a specified location.
	 * @param gr the grid to put the Actor in
	 * @param loc location the Actor should be in the grid
	 */
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
	
    /**
     * The act method defines the actions of the Actor.
     */
	public void act() {
		
	}
	
	/**
	 * The paint method draws the Actor at a given location.
	 * @param g the Graphics component
	 * @param x the x-coordinate of the location
	 * @param y the y-coordinate of the location
	 */
	public abstract void paint(Graphics g, int x, int y);
	
	/**
	 * The toString method returns information about the Actor.
	 * @return the the Actor, its location, and its direction
	 */
	public String toString() {
		return getClass().getName() + "[location=" + location + ",direction="
                + direction +  "]";
	}
	
	
}