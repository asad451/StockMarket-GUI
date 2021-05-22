import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AnotherGUI extends JFrame {

	JPanel p = new JPanel();    
	JLabel title;

	public AnotherGUI() {
		
	    title = new JLabel("Data for MSFT");
        title.setBounds(100,100,100,30);
        title.setFont(new Font("Serif", Font.PLAIN, 28));
        title.setForeground(Color.white);
        p.add(title);
		  
	    setSize(830,600);   
	    getContentPane().setBackground(Color.darkGray);
	    setLocation(600,300);
	    setVisible(true);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
