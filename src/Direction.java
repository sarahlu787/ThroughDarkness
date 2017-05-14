public class Direction 
{
	private double direction; 

	public Direction() 
	{
		direction = 0;
		
	}
	
	
	
	public void getDirection(Character c, Exit e)
	{
		int x = e.getLocation().getRow()-c.getCurrentPosition().getRow();
		int y = e.getLocation().getCol()-c.getCurrentPosition().getCol();
		direction = Math.toDegrees(Math.atan(y/x));
		
	}

	
	public void draw()
	{
		
	}

}