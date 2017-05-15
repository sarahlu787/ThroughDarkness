
/**
 * The Direction class displays the direction as an arrow from the character to the exit.
 * @author Sarah Lu, Ally Wang
 * @version 5/15/17
 *
 */
public class Direction 
{
	private double direction; 

	public Direction() 
	{
		direction = 0;
		
	}
	
	
	/**
	 * The getDirection method finds the direction from the Character to the Exit.
	 * @param c the Character object
	 * @param e the Exit object
	 */
	public void getDirection(Character c, Exit e)
	{
		int x = e.getLocation().getRow()-c.getRow();
		int y = e.getLocation().getCol()-c.getCol();
		direction = Math.toDegrees(Math.atan(y/x));
		
	}

	/**
	 * The draw method draws the direction on the screen.
	 */
	public void draw()
	{
		
	}

}
