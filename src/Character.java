
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
	
	public void act()
	{
		
	}
	
	
	
	// returns the current position of the character
	// might have to make a package like what we did in GridWorld?
	public Location getCurrentPosition(){

		return location;
	}


}
