
import java.util.ArrayList;
import java.util.Collections;

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
	private Exit exit;
	
	private boolean[][] isWall;
	
	Direction direction = new Direction();
	private Object[][] occupantArray;
	private int rows,cols;
	private int cr, cc;
	private int er,ec;
	
	/**
	 * The constructor creates a 2D array for the grid and adds Actors to it.
	 * @param rows the number of rows in the grid
	 * @param cols the number of columns in the grid
	 */
	public Grid(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		occupantArray = new Object[rows][cols];

		
		
		generateActor();
		
	}
	
	
	public void generateActor()
	{
		boolean[][] isWall = this.isWall();
		for (int i = 0; i < isWall.length; i++)
		{
			for (int j = 0; j < isWall.length; j++)
			{
				if (isWall[i][j])
				{
					Wall w = new Wall();
					w.putSelfInGrid(this, new Location(i,j));
				}
			}
		}
		character = new Character();
		character.putSelfInGrid(this, new Location(cc, cr));
		exit = new Exit();
		exit.putSelfInGrid(this, new Location(er,ec));
	}
	

	
	public boolean[][] isWall()
	{
		isWall = new boolean[rows][cols]; 
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				isWall[i][j] = true;
			}
		}
		
		//starting point
		int r = (int)(Math.random()*rows);
		int c = (int)(Math.random()*cols);
		isWall[r][c] = false;
		cr = r;
		cc = c;
		
		int r2 = 0,c2 = 0;
		while((r2<=2 || r2>rows-2) || (c2<=2 || c2>cols-2))
		{
			r2 = (int)(Math.random()*rows);
			c2 = (int)(Math.random()*cols);
		}
		//isWall[r2][c2] = false;
		er = r2;
		ec = c2;
		generateMaze(r,c);
		
		
		return isWall;
	}
	
	
	
	
	public void setExit(){
		
		boolean[][] wall = isWall();
		ArrayList<Location> l = new ArrayList<Location>();
		for (int i = 0; i <wall.length; i++)
		{
			for (int j = 0; j < wall[0].length; j++)
			{
				if (wall[i][j]==false)
					l.add(new Location(i,j));
			}
		}
		
		int a = (int)(Math.random()*l.size());

		exit.putSelfInGrid(this, l.get(a));
	}
	
	
	public void generateMaze(int r, int c)
	{
		Integer[] directions = generateDirections(); 
		for (int i = 0; i < 4; i++)
		{
			if (directions[i] == 0)
			{
				if (r - 2 <= 0)
				{
					break;
				}
				if (isWall[r-2][c])
				{
					isWall[r-2][c] = false;
					isWall[r-1][c] = false;
					generateMaze(r-2,c);
				}
			}
			else if (directions[i] == 1)
			{
				if (c+2 >= cols-1)
				{
					break;
				}
				if (isWall[r][c+2])
				{
					isWall[r][c+2] = false;
					isWall[r][c+1] = false;
					generateMaze(r,c+2);
				}
			}
			else if (directions[i]==2)
			{
				if (r+2 >= rows-1)
				{
					break;
				}
				if (isWall[r+2][c])
				{
					isWall[r+2][c] = false;
					isWall[r+1][c] = false;
					generateMaze(r+2,c);
				}
			}
			else 
			{
				if (c-2 <= 0)
				{
					break;
				}
				if (isWall[r][c-2])
				{
					isWall[r][c-2] = false;
					isWall[r][c-1] = false;
					generateMaze(r,c-2);
				}
			}
		}
		
		
	}
	
	
	public int getcc()
	{
		return cc;
	}
	
	public int getcr()
	{
		return cr;
	}
	
	public Integer[] generateDirections()
	{
		ArrayList<Integer> directions = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++)
		{
			directions.add(i);
		}
		Collections.shuffle(directions);
		return directions.toArray(new Integer[4]);
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
		return cols;
	}

	@Override
	/**
	 * The getNumRows returns the number of rows in the grid.
	 * @return the number of rows in the grid
	 */
	public int getNumRows() {
		return rows;
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
	/**
	 * The getExit method returns the Exit in the grid.
	 * @return the Exit from the grid
	 */
	public Exit getExit()
	{
		return exit;
	}

	 
}