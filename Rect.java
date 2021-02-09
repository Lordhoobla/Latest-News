import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class Rect extends JPanel{
	protected static int x,x2,x3,y,y2,y3,w,w2,w3,l,l2,l3;
	protected static Color c,c2,c3,c4;
	protected static String text;
	public void paintComponent(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        g2.drawRect(x,y,w,l);
        g2.setColor(c);
        g2.fillRect(x,y,w,l);
        g2.drawRect(x2,y2,w2,l2);
        g2.setColor(c2);
        g2.fillRect(x2,y2,w2,l2);
        g2.drawRect(x3,y3,w3,l3);
        g2.setColor(c3);
        g2.fillRect(x3,y3,w3,l3);
        g2.setColor(c4);
        g2.drawString(text,130,100);
    } 
}
