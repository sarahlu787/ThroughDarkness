import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JFrame{
	JPanel cardPanel;
	GridPanel gridPanel;
	Sound bgm = new Sound("Misty-Bog_Looping.wav");
	/**
	 * The constructor creates the HomeScreen, Grid, and adds them o the window. 
	 * It also sets the number of rows and columns in the grid.
	 * @param title the name of the Main object
	 */
	public Main(String title) {
		
		super(title);
		bgm.play();
		
		setBounds(100, 100, 800, 750);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		HomeScreen panel1 = new HomeScreen(this);
	    gridPanel = new GridPanel(this);
	    InstructionScreen panel3 = new InstructionScreen(this);
	    SuccessScreen panel4 = new SuccessScreen(this);
		//JLabel label1 = new JLabel("   11233 ");
		//panel3.add(label1);
	    
	    //addKeyListener(panel2.getKeyHandler());
	
	    cardPanel.add(panel1,"1");
	    cardPanel.add(gridPanel, "gridPanel");
	    cardPanel.add(panel3,"3");
	    cardPanel.add(panel4, "success");
	    
	    add(cardPanel);
	
	    setVisible(true);
	}

	/**
	 * The main method creates a new Main object called ThroughDarkness.
	 * @param args the parameter for the main method
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
	}
	
	
	/**
	 * Starts a new game.
	 */
	public void startGame() {
		changePanel("gridPanel");
		gridPanel.startGame();
	}
}
