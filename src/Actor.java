
public class Actor 
{
	//private Grid<Actor> grid;
	private Location location;
	private int direction;
	//private Color color;
	
	public Actor() {
		//color = Color.BLACK;
		//grid = null;
		location = null;
	}
	
	// getColor()
	// setColor()
	
	public int getDirection() {
		return direction;
	}
	
	public void setDirection(int newDirection) {
	
	}
	
	
	/*
	public Grid<Actor> getGrid() {
		return grid;
	}
	*/
	
	public void act() {
		
	}
	
	public String toString() {
		return getClass().getName() + "[location=" + location + ",direction="
                + direction +  "]";
	}
	
	
}
