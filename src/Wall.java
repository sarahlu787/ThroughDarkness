import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Wall extends Actor
{
	
	private Image wall;

	public Wall() 
	{
		wall = new ImageIcon("wall.jpg").getImage();
	}
	


	@Override
	public void paint(Graphics g, int x, int y) {
		g.drawImage(wall,x,y,GridPanel.GRID_SIZE,GridPanel.GRID_SIZE,null);
		
	}


}