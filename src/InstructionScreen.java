import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InstructionScreen extends JPanel implements ActionListener{

	Main w;
		
	public InstructionScreen(Main w) {
		this.w = w;

		setLayout(null);
		JButton button = new JButton("BACK");
		button.setBounds(w.getWidth()/2-50,w.getHeight()-100,100,20);

		button.addActionListener(this);

		
		add(button);


	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Right Arrow Key: moves the character right", 100, 100);
		g.drawString("Left Arrow Key: moves the character left", 100, 120);
		g.drawString("Up Arrow Key: moves the character up",100,140);
		g.drawString("Down Arrow Key: moves the character down", 100, 160);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		w.changePanel("1");
		
	}
	

	
	
}
