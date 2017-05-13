import java.util.ArrayList;

import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;

public class Grid<E> extends AbstractGrid<E>
{
	
	private Character character;
	private ArrayList<Wall> obstacles;
	  
	private KeyHandler keyControl;
	
	Direction direction = new Direction();
	private Object[][] occupantArray;
	
	public Grid(int rows, int cols) {
		occupantArray = new Object[rows][cols];
	}

	@Override
    public E get(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        return (E) occupantArray[loc.getRow()][loc.getCol()]; // unavoidable warning
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
    public E put(Location loc, E obj)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        if (obj == null)
            throw new NullPointerException("obj == null");

        // Add the object to the grid.
        E oldOccupant = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = obj;
        return oldOccupant;
    }

	@Override
    public E remove(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        
        // Remove the object from the grid.
        E r = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return r;
    }
}
