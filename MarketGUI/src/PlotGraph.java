import java.awt.*;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class PlotGraph extends JPanel{

	public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;
        setBackground(Color.DARK_GRAY);
   
        //Drawing Axis
        g2.setColor(Color.WHITE);
        g2.draw( new Line2D.Double(100,100,100,500));
        g2.draw( new Line2D.Double(100,500,900,500));
   
        //Drawing Data using Lines
        
        //For Open
        g2.setColor(Color.yellow);
        g2.drawLine(200, 400, 350, 200);
        g2.drawLine(350, 200, 700, 250);
        g2.drawLine(700, 250, 750, 150);
        g2.drawLine(1100, 95, 1140, 95);
        g.drawString("Open", 1060, 100);

        //For High
        g2.setColor(Color.cyan);
        g2.drawLine(150, 450, 450, 200);
        g2.drawLine(450, 200, 800, 200);
        g2.drawLine(1100, 145, 1140, 145);
        g.drawString("High", 1060, 150);

        //For Low
        g2.setColor(Color.pink);
        g2.drawLine(250, 450, 650, 450);
        g2.drawLine(650, 450, 850, 300);
        g2.drawLine(1100, 195, 1140, 195);
        g.drawString("Low", 1060, 200);
        
        //For Close
        g2.setColor(Color.white);
        g2.drawArc(230, 190, 620, 240, 215, 140);
        g2.drawLine(1100, 245, 1140, 245);
        g.drawString("Close", 1060, 250);
        
        
        //Labelling Axis and heading of the window
        g.setFont(new Font("Serif", Font.PLAIN, 24));
        g.setColor(Color.white);
        g.drawString("Dates", 450, 550);
        g.drawString("Data", 35, 300);
        g.setFont(new Font("Serif", Font.PLAIN, 34));
        g.drawString("Graph for Stock Market", 370, 50);
    }

//public static void main(String [] args) {
//
//    JFrame f = new JFrame();
//    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    f.getContentPane().add(new PlotGraph());
//    f.setSize(1250,650);
//    f.setLocation(300,300);
//    f.setVisible(true);
//}
}