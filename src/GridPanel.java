
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	private Image blackBG = new ImageIcon("black.jpg").getImage();
	private Direction direction = new Direction();
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
	/**
	 * The constructor sets the grid.
	 * @param grid the grid object from Main
	 */
	public GridPanel(Main w) {
		this.w = w;
		setLayout(null);
		
		setFocusable(true);
		requestFocus();
	    addKeyListener(this);

		button1 = new JButton("BACK");
		button1.setBounds(w.getWidth()/2-50,w.getHeight()-100,100,20);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				w.changePanel("1");
			}
			
		});
		add(button1);
		
		
		button2 = new JButton("RESET CHARACTER");
		button2.setBounds(w.getWidth()/2-100,w.getHeight()-70,200,20);

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				grid.resetCharacter();
				GridPanel.this.requestFocus();
				repaint();
			}
			
		});
		add(button2);
		

	}
	
	@Override
	
	/**
	 * The paintComponent method draws the grid and all the Actors in it.
	 * @param g the Graphics component
	 */
	protected void paintComponent(Graphics g) {
		
		
		
		//g.drawLine(10, 20, 30, 40);
		
		//g.drawImage(blackBG, 0, 0, grid.getNumCols()*GRID_SIZE, grid.getNumRows()*GRID_SIZE, this);

		//g.drawImage(background, 0, 0, grid.getNumCols()*GRID_SIZE, grid.getNumRows()*GRID_SIZE, this);
		g.setColor(Color.WHITE);
		//g.fillRect(0, 0, grid.getNumCols()*GRID_SIZE, grid.getNumRows()*GRID_SIZE);
		//g.fillRect(grid.getNumCols()*GRID_SIZE, 0,w.getWidth()-grid.getNumCols()*GRID_SIZE,w.getHeight());
		
		g.fillRect(0, 0, w.getWidth(), w.getHeight());
		
		
		
		
		for (int r = 0; r < grid.getNumRows(); r++) {
			for (int c = 0; c < grid.getNumCols(); c++) {
				Actor actor = grid.get(new Location(r, c));
				//System.out.println(x + " " + y + " " + actor );
				if (actor != null){
				    actor.paint(g, c * GRID_SIZE, r * GRID_SIZE);
				    
				}
					
			}
			
		}
		g.setColor(Color.WHITE);
		g.fillRect(grid.getNumCols()*GRID_SIZE, 0,w.getWidth()-grid.getNumCols()*GRID_SIZE,w.getHeight());

		int x = grid.getCharacter().getCol()*GRID_SIZE;
		int y = grid.getCharacter().getRow()*GRID_SIZE;
		

		
		g.setColor(Color.BLACK);
		g.fillRect(0,0, x-40, y-40);
		g.fillRect(0, y-40, x-40, grid.getNumRows()*GRID_SIZE-(y-40));
		g.fillRect(x-40,y+GRID_SIZE+40,grid.getNumCols()*GRID_SIZE-(x-40),grid.getNumRows()*GRID_SIZE-80-GRID_SIZE-(y-40));
		g.fillRect(x-40, 0, grid.getNumCols()*GRID_SIZE-(x-40),y-40);
		g.fillRect(x+40+GRID_SIZE, y-40,grid.getNumRows()*GRID_SIZE-80-GRID_SIZE-(x-40),80+GRID_SIZE);
		
		//g.drawImage(blackBG, 0, 0, grid.getNumCols()*GRID_SIZE, grid.getNumRows()*GRID_SIZE, this);
		//grid.getCharacter().paint(g, grid.getcr(), grid.getcc());
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(100));
		g2d.drawOval(x-90, y-90, 196, 196);
		
		g.setColor(Color.WHITE);
		g.fillRect(grid.getNumCols()*GRID_SIZE, 0,w.getWidth()-grid.getNumCols()*GRID_SIZE,w.getHeight());
		g.fillRect(0, grid.getNumRows()*GRID_SIZE, w.getWidth(), w.getHeight()-grid.getNumRows()*GRID_SIZE);
		
		g.setColor(Color.BLACK);
		
		double theta = direction.getDirection(grid.getCharacter(), grid.getExit());
		direction.paint(g, theta);

		
		
		
		
		int col = grid.getCharacter().getCol();
		int row = grid.getCharacter().getRow();
		int eCol = grid.getExit().getCol();
		int eRow = grid.getExit().getRow();
		if (row == eRow-1 && col == eCol || row == eRow+1 && col == eCol || row == eRow && col == eCol-1 || row == eRow && col == eCol+1)
			w.changePanel("success");
		
		
		
		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * The keyPressed method defines the Character's movement when certain keys are pressed as well as the keyword to restart the game.
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
		} else if(e.getKeyCode() == KeyEvent.VK_R){
			w.startGame();
		}
		
		repaint();
		
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	/**
	 * Creates a new grid and sets its size.
	 */
	public void startGame() {
		requestFocus();
		int row = 41;
		int col = 41;
		grid = new Grid(row, col);
	}
	
} 
