import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Actor
{

	public Wall() 
	{
		setColor(Color.BLACK);
	}
	
	
	//override and does nothing
	public void act() 
	{
		
	}


	@Override
	public void paint(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
