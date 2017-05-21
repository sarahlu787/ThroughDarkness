
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The HomeScreen class displays the home screen and its buttons.
 * @author Sarah Lu, Ally Wang
 * @version 5/15/17
 *
 */
public class SuccessScreen extends JPanel {

	Main w;
	private Image image;
	private JButton button;
	
	/**
	 * The constructor sets the background and adds the buttons.
	 * @param w the Main object (the window)
	 */
	public SuccessScreen(Main w) {
		image = new ImageIcon("congrets.png").getImage();
		this.w = w;
		button = new JButton("RESTART");

		setLayout(null);
		button.setBounds(w.getWidth()/2-50,w.getHeight()/2-60,100,20);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				w.changePanel("1");
			}
			
		});
		add(button);
		
	
		
	}
	
	/**
	 * The paintComponent method draws everything on the home screen 
	 * @param g the Graphics component
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, w.getHeight()/3, w.getWidth(), w.getHeight()/3, this);
		button.setBounds(w.getWidth()/2-50,w.getHeight()-w.getHeight()/10,100,20);
	}
	
}