import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelVentanaTablero  extends JPanel{
	Tablero tablero;
	List<Jugador>jugadores;
	Graphics2D g2;
	
	double anchoAlturaCasilla=50;
	double ubicacionX=40;
	double ubicacionY=60;
	public PanelVentanaTablero(Tablero tablero) {
		this.tablero=tablero;
		this.jugadores=tablero.getJugadores();
	}
		
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g2= (Graphics2D)g;

	setBackground(Color.lightGray);
	
	Rectangle2D rectangulo=new Rectangle2D.Double(120,100,anchoAlturaCasilla,anchoAlturaCasilla);
	int filasMapa=tablero.mapa.length;
	int columnasMapa=tablero.mapa[0].length;

	
	for(int i=0;i<filasMapa;i++) {
		for(int j=0;j<columnasMapa;j++) {
			rectangulo.setFrame(ubicacionX+(j*anchoAlturaCasilla),ubicacionY+(i*anchoAlturaCasilla), anchoAlturaCasilla, anchoAlturaCasilla);
			if(tablero.mapa[i][j]!=null) {
			g2.setPaint(tablero.mapa[i][j].getColor());
			g2.fill(rectangulo);
			g2.setPaint(Color.BLACK);
			g2.draw(rectangulo);
			}
			//Thread.sleep(1000);
		
			Rectangle2D figJugador=new Rectangle2D.Double(120,100,anchoAlturaCasilla/2,anchoAlturaCasilla/2);
			for (Jugador jugador : jugadores) {
				double h =(double) jugador.getLugarTableroX();
				double p=(double)jugador.getLugarTableroY();
				figJugador.setFrame(ubicacionX+(anchoAlturaCasilla/4)+p*(anchoAlturaCasilla),ubicacionY+(anchoAlturaCasilla/4)+h*(anchoAlturaCasilla), anchoAlturaCasilla/2, anchoAlturaCasilla/2);
				g2.setPaint(Color.BLACK);
				g2.fill(figJugador);				
				
				
			
			}
			
		
		}
	
		
		
	}

	
	
}
private class ColorDeFondo implements ActionListener{
	private Color colorDeFondo;
	public ColorDeFondo(Color c) {
		colorDeFondo=c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setBackground(colorDeFondo);
	
		
	}
	
}
public void movimientoJugador(Jugador jugador,String direccion) throws InterruptedException {
	double pixelOrigenX=ubicacionX+(anchoAlturaCasilla/4)+jugador.getPosicionAnteriorX()*(anchoAlturaCasilla);
	double pixelOrigenY=ubicacionY+(anchoAlturaCasilla/4)+jugador.getPosicionAnteriorY()*(anchoAlturaCasilla);
	double pixelDestinoX=ubicacionX+(anchoAlturaCasilla/4)+jugador.getLugarTableroX()*(anchoAlturaCasilla);
	double pixelDestinoY=ubicacionX+(anchoAlturaCasilla/4)+jugador.getLugarTableroY()*(anchoAlturaCasilla);
	Rectangle2D figJugador=new Rectangle2D.Double(120,100,anchoAlturaCasilla/2,anchoAlturaCasilla/2);
	
	if(direccion.equals("abajo")) {
		for(int i=(int)pixelOrigenX;i<pixelDestinoX;i++) {
			System.out.println("direccion: " + direccion);
			 {
				figJugador.setFrame(pixelOrigenX+5,pixelDestinoY, anchoAlturaCasilla/2, anchoAlturaCasilla/2);
			    g2.setPaint(Color.BLACK);
				g2.fill(figJugador);
				
				repaint();
				
			}
		}
	}

}

}

