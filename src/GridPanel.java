import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import info.gridworld.grid.Location;

public class GridPanel extends JPanel implements KeyListener{
  
	private static final int GRID_SIZE = 20;
	private Grid grid;
	

	public GridPanel(Grid grid) {
		this.grid = grid;

	}

	@Override
	protected void paintComponent(Graphics g) {
		//g.drawLine(10, 20, 30, 40);
		for (int y = 0; y < grid.getNumRows(); y++) {
			for (int x = 0; x < grid.getNumCols(); x++) {
				Actor actor = grid.get(new Location(x, y));
				System.out.println(x + " " + y + " " + actor );
				if (actor != null){
				    actor.paint(g, x * GRID_SIZE, y * GRID_SIZE);
				    
				}
					
			}
		}
	}
	
	
	
	
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Character c = grid.getCharacter();
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			c.moveLeft();
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			c.moveRight();
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			c.moveDown();
		} else if(e.getKeyCode() == KeyEvent.VK_UP){
			c.moveUp();
		}
		
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
