
import java.util.ArrayList;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

public class Grid extends AbstractGrid<Actor>
{
	
	
	private Character character;
	private ArrayList<Wall> obstacles;
	private Wall wall;

	
	Direction direction = new Direction();
	private Object[][] occupantArray;
	
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
    public Actor get(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        return (Actor) occupantArray[loc.getRow()][loc.getCol()]; // unavoidable warning
    }

	@Override
	public int getNumCols() {
		return occupantArray.length;
	}

	@Override
	public int getNumRows() {
		return occupantArray[0].length;
	}

	@Override
	public ArrayList<Location> getOccupiedLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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
	
	public Character getCharacter() {
		return character;
	}
	


	 
}