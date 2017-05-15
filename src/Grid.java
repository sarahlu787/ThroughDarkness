
import java.util.ArrayList;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;


/** 
 * The grid class creates a grid of Actors.
 * 
 * @author Sarah Lu, Ally Wang
 * @version 5/15/17
 */

public class Grid extends AbstractGrid<Actor>
{
	
	
	private Character character;
	private ArrayList<Wall> obstacles;
	private Wall wall;

	
	Direction direction = new Direction();
	private Object[][] occupantArray;
	
	/**
	 * The constructor creates a 2D array for the grid and adds Actors to it.
	 * @param rows the number of rows in the grid
	 * @param cols the number of columns in the grid
	 */
	public Grid(int rows, int cols) {
		occupantArray = new Object[rows][cols];
		character = new Character();
		character.putSelfInGrid(this, new Location(rows/2, cols/2));
		obstacles = new ArrayList<Wall>();
		
		for(int i = 0; i < cols; i++) {
			//wall = new Wall();
			obstacles.add(new Wall());
			if(i < cols/2)
				obstacles.get(i).putSelfInGrid(this, new Location(5,i));
			if(i > cols/2) 
				obstacles.get(i).putSelfInGrid(this, new Location(7,i));

			
		}
	}
	
	@Override
	/**
	 * The get method gets the Actor at a given location.
	 * @param loc the location in the grid
	 * @return the Actor if the location is valid, throw an exception otherwise
	 */
    public Actor get(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        return (Actor) occupantArray[loc.getRow()][loc.getCol()]; // unavoidable warning
    }

	@Override
	/**
	 * The getNumCols returns the number of columns in the grid.
	 * @return the number of columns
	 */
	public int getNumCols() {
		return occupantArray.length;
	}

	@Override
	/**
	 * The getNumRows returns the number of rows in the grid.
	 * @return the number of rows in the grid
	 */
	public int getNumRows() {
		return occupantArray[0].length;
	}

	@Override
	public ArrayList<Location> getOccupiedLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * The isValid method determines if a given location is valid.
	 * @param loc the location in the grid
	 * @return true if the location is within the boundaries of the grid, false otherwise
	 */
	public boolean isValid(Location loc) {
	    return 0 <= loc.getRow() && loc.getRow() < getNumRows()
	             && 0 <= loc.getCol() && loc.getCol() < getNumCols();
	}

	@Override
    public Actor put(Location loc, Actor obj)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        if (obj == null)
            throw new NullPointerException("obj == null");

        // Add the object to the grid.
        Actor oldOccupant = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = obj;
        return oldOccupant;
    }

	@Override
    public Actor remove(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        
        // Remove the object from the grid.
        Actor r = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return r;
    }
	
	/**
	 * The getCharacter method returns the Character in the grid.
	 * @return the Character from the grid
	 */
	public Character getCharacter() {
		return character;
	}
	


	 
}