import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeScreen extends JPanel {

	Main w;
	private Image image;
	private JButton button,button1;
	public HomeScreen(Main w) {
		image = new ImageIcon("background.jpg").getImage();
		this.w = w;
		button = new JButton("START");

		setLayout(null);
		button.setBounds(w.getWidth()/2-50,w.getHeight()/2-60,100,20);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				w.changePanel("2");
			}
			
		});
		add(button);
		
		button1 = new JButton("INSTRUCTIONS");
		button1.setBounds(w.getWidth()/2-80,w.getHeight()/2,160,20);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				w.changePanel("3");
				
			}
			
		});
		add(button1);
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, w.getWidth(), w.getHeight(), this);
		button.setBounds(w.getWidth()/2-50,w.getHeight()/2-60,100,20);
		button1.setBounds(w.getWidth()/2-80,w.getHeight()/2,160,20);
	}
	
}