import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;



public class PanelDado extends JPanel implements Runnable{
	private Rectangle2D rectangulo;
	private Graphics2D g2;
	double rot=100;
	public PanelDado() {
		
	}
public void paintComponent(Graphics g) {	
	rectangulo= new Rectangle(100, 100, 100, 100);
	
	g.draw3DRect(100, 100, 100, 100, true);
	
	g.fill3DRect(100, 100, 100, 100, true);
	
}
	@Override
	public void run() {
		// TODO Apéndice de método generado automáticamente
		System.out.println("das");
		for(double j=0;j<rot;j++) {
		g2.rotate(j, 100-j, 100-j);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		repaint();
		}
	}
	

}
