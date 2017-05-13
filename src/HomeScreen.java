import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeScreen extends JPanel {

	Main w;
		
	public HomeScreen(Main w) {
		this.w = w;
		JButton button = new JButton("START");

		setLayout(null);
		button.setBounds(w.getWidth()/2-50,w.getHeight()/2-60,100,20);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				w.changePanel("2");
			}
			
		});
		add(button);
		
		JButton button1 = new JButton("INSTRUCTIONS");
		button1.setBounds(w.getWidth()/2-80,w.getHeight()/2,160,20);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				w.changePanel("3");
				
			}
			
		});
		add(button1);
		

	}
	
}
