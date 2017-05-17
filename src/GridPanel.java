import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import info.gridworld.grid.Location;

/**
 * The GridPanel displays the grid, the actors in the grid, and defines the Character's movements.
 * @author Sarah Lu, Ally Wang
 * @version 5/15/17
 *
 */
public class GridPanel extends JPanel implements KeyListener{
  
	Main w;
	public static final int GRID_SIZE = 16;
	private Grid grid;
	private Image background = new ImageIcon("whiteBackground.jpg").getImage();
	private Direction direction = new Direction();
	private JButton button1;
	private JButton button2;
	
	/**
	 * The constructor sets the grid.
	 * @param grid the grid object from Main
	 */
	public GridPanel(Grid grid, Main w) {
		this.grid = grid;
		this.w = w;
		setLayout(null);
		
		button1 = new JButton("BACK");
		button1.setBounds(w.getWidth()/2-50,w.getHeight()-60,100,20);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				w.changePanel("1");
			}
			
		});
		add(button1);
		

	}

	
	public void generateActor()
	{
		for (int i = 0; i < grid.isWall().length; i++)
		{
			for (int j = 0; j < grid.isWall().length; j++)
			{
				if (grid.isWall()[i][j])
				{
					Wall w = new Wall();
					w.putSelfInGrid(grid, new Location(i,j));
				}
			}
		}
		Character c = new Character();
		c.putSelfInGrid(grid, new Location(grid.getcc(),grid.getcr()));
	}
	
	@Override
	
	/**
	 * The paintComponent method draws the grid and all the Actors in it.
	 * @param g the Graphics component
	 */
	protected void paintComponent(Graphics g) {
		//g.drawLine(10, 20, 30, 40);
		g.drawImage(background, 0, 0, grid.getNumCols()*GRID_SIZE, grid.getNumRows()*GRID_SIZE, this);
		
		generateActor();
		
		
		for (int r = 0; r < grid.getNumRows(); r++) {
			for (int c = 0; c < grid.getNumCols(); c++) {
				Actor actor = grid.get(new Location(r, c));
				//System.out.println(x + " " + y + " " + actor );
				if (actor != null){
				    actor.paint(g, c * GRID_SIZE, r * GRID_SIZE);
				    
				}
					
			}
			
		}
		
		int rows = grid.getNumRows();
		//int cols = grid.getNumCols();
		double degree = direction.getDirection(grid.getCharacter(), grid.getExit());
		direction.paint(g, degree, rows);
		
		
		
		
	}
	
	
	/**
	 * The getGrid Size method returns the size of the grid.
	 * @return the size of the grid as an integer
	 */
	public int getGridSize() {
		return GRID_SIZE;
	}
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * The keyPressed method defines the Character's movement when certain keys are pressed.
	 */
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
