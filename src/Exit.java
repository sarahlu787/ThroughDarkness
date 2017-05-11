
import info.gridworld.grid.Location;

public class Exit extends Actor
{
	private Location location;
	
	public Exit(int row, int col)
	{
		location = new Location(row, col);
	}
	

	public Location getLocation() 
	{
		return location;
	}
	

}
