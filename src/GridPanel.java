import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import info.gridworld.grid.Location;

public class GridPanel extends JPanel implements KeyListener{
  
	public static final int GRID_SIZE = 16;
	private Grid grid;
	private Image background = new ImageIcon("whiteBackground.jpg").getImage();

	public GridPanel(Grid grid) {
		this.grid = grid;

	}

	@Override
	protected void paintComponent(Graphics g) {
		//g.drawLine(10, 20, 30, 40);
		g.drawImage(background, 0, 0, grid.getNumCols()*GRID_SIZE, grid.getNumRows()*GRID_SIZE, this);
		
		for (int r = 0; r < grid.getNumRows(); r++) {
			for (int c = 0; c < grid.getNumCols(); c++) {
				Actor actor = grid.get(new Location(r, c));
				//System.out.println(x + " " + y + " " + actor );
				if (actor != null){
				    actor.paint(g, c * GRID_SIZE, r * GRID_SIZE);
				    
				}
					
			}
		}
	}
	
	
	
	public int getGridSize() {
		return GRID_SIZE;
	}
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Character c = grid.getCharacter();
		//System.out.println(grid.getCharacter());
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
