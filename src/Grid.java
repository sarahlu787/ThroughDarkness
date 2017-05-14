import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
		keyControl = new KeyHandler();
		occupantArray = new Object[rows][cols];
	}

	 public KeyHandler getKeyHandler() {
		  return keyControl;
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
	
	
	public class KeyHandler implements KeyListener {

		  private ArrayList<Integer> keys;

		  public KeyHandler() {
			  keys = new ArrayList<Integer>();
		  }

		  public void keyPressed(KeyEvent e) {
			  keys.add(e.getKeyCode());
		  }

		  public void keyReleased(KeyEvent e) {
			  Integer code = e.getKeyCode();
			  while(keys.contains(code))
				  keys.remove(code);
		  }

		  public void keyTyped(KeyEvent e) {

		  }
		  
		  public boolean isPressed(int code) {
			  return keys.contains(code);
		  }

		


	  }
}