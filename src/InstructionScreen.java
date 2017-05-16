import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The InstructionScreen displays the screen of instructions and its buttons.
 * @author Sarah Lu, Ally Wang
 * @version 5/15/17
 *
 */
public class InstructionScreen extends JPanel implements ActionListener{

	Main w;
	private JButton button;
	private Image image;
	
	/**
	 * The constructor sets the layout and the buttons.
	 * @param w the Main object (the window)
	 */
	public InstructionScreen(Main w) {
		this.w = w;

		setLayout(null);
		w.setBackground(Color.BLUE);
		button = new JButton("BACK");
		button.setBounds(w.getWidth()/2-50,w.getHeight()-100,100,20);

		button.addActionListener(this);
		
		image = new ImageIcon("instrucB.jpg").getImage();

		
		add(button);


	}

	/**
	 * The paintComponent method displays the instrutions on the screen and sets the location of the button.
	 * @param g the Graphics component
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, 0, 0, w.getWidth(), w.getHeight(), this);
		g.setColor(Color.WHITE);
		Font font = g.getFont().deriveFont( 15.0f );
		g.setFont(font);
		g.drawString("Right Arrow Key: moves the character right",w.getWidth()/10,w.getHeight()/10);
		g.drawString("Left Arrow Key: moves the character left", w.getWidth()/10, w.getHeight()/5);
		g.drawString("Up Arrow Key: moves the character up",w.getWidth()/10, w.getHeight()/10*3);
		g.drawString("Down Arrow Key: moves the character down", w.getWidth()/10, w.getHeight()/5*2);
		button.setBounds(w.getWidth()/2-50,w.getHeight()-100,100,20);
	}
	
	@Override
	/**
	 * The actionPerformed method changes the panel to the home screen when the button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		w.changePanel("1");
		
	}
	

	
	
}