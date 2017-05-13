import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeScreen extends JPanel implements ActionListener{

	Main w;
		
	public HomeScreen(Main w) {
		this.w = w;
		JButton button = new JButton("START");
		button.addActionListener(this);
		add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		w.changePanel("2");
	}

	

}
