import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main extends JFrame{
	
	private int row;
	private int col;
	
	JPanel cardPanel;
	
	/**
	 * The constructor creates the HomeScreen, Grid, and adds them o the window. 
	 * It also sets the number of rows and columns in the grid.
	 * @param title the name of the Main object
	 */
	
	public Main(String title) {
		super(title);
		row = 40;
		col = 40;

		
		setBounds(100, 100, 700, 700);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		HomeScreen panel1 = new HomeScreen(this);
		Grid grid = new Grid(row, col);
	    GridPanel panel2 = new GridPanel(grid,this);
	    this.addKeyListener(panel2);
	    InstructionScreen panel3 = new InstructionScreen(this);
		//JLabel label1 = new JLabel("   11233 ");
		//panel3.add(label1);
	    
	    //addKeyListener(panel2.getKeyHandler());
	
	    cardPanel.add(panel1,"1");
	    cardPanel.add(panel2,"2");
	    cardPanel.add(panel3,"3");
	    
	    add(cardPanel);
	
	    setVisible(true);
	}

	/**
	 * The main method creates a new Main object called ThroughDarkness.
	 * @param args the parameter for the main mehtod
	 */
	public static void main(String[] args)
	{
		Main w = new Main("ThroughDarkness");
	}
  
	/**
	 * The changePanel changes the panel's layout.
	 * @param name the name of the panel
	 */
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
	}
}
