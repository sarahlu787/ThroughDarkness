import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeScreen extends JPanel implements ActionListener{

	Main w;
		
	public HomeScreen(Main w) {
		this.w = w;
		JButton button = new JButton("START");

		JButton button2 = new JButton("INSTRUCTIONS");
		button.setBounds(w.getWidth()/2-50,w.getHeight()/2-60,100,20);
		button2.setBounds(w.getWidth()/2-80,w.getHeight()/2,160,20);
		
		button.addActionListener(this);
		w.add(button);
		button2.addActionListener(this);
		w.add(button2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		w.changePanel("2");
	}

	

}
