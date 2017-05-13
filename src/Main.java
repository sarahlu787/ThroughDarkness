import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
	
	private int row;
	private int col;
	
	JPanel cardPanel;
	
	public Main(String title) {
		super(title);
		row = 20;
		col = 20;
		
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		HomeScreen panel1 = new HomeScreen(this);    
	    Grid panel2 = new Grid(row,col);
	    InstructionScreen panel3 = new InstructionScreen(this);
	    
	    addKeyListener(panel2.getKeyHandler());
	    addKeyListener(panel3.getKeyHandler());
	
	    cardPanel.add(panel1,"1");
	    //cardPanel.add(panel2,"2");
	    cardPanel.add(panel3,"3");
	    
	    add(cardPanel);
	
	    setVisible(true);
	}

	public static void main(String[] args)
	{
		Main w = new Main("ThroughDarkness");
	}
  
	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		requestFocus();
	}
}
