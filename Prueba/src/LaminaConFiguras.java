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

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LaminaConFiguras  extends JPanel{
	private Image imagen;
	JButton botonNegro= new JButton("pintar de Negro");
	JButton botonAzul=new JButton("pintar de azul");
	public LaminaConFiguras() {
		//add(botonNegro);
		//add(botonAzul);
		ColorDeFondo negro=new ColorDeFondo(Color.black);
		ColorDeFondo azul=new ColorDeFondo(Color.blue);
		botonNegro.addActionListener(negro);
		botonAzul.addActionListener(azul);
	}
		
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2= (Graphics2D)g;
	
	double anchoAlturaCasilla=30;
	double ubicacionX=50;
	double ubicacionY=50;
	
	Rectangle2D rectangulo=new Rectangle2D.Double(120,100,anchoAlturaCasilla,anchoAlturaCasilla);

	
	for(int i=0;i<10;i++) {
	g2.setColor(Color.GREEN);
	g2.fill3DRect(100+i*100, 100, 100, 100, true);
	g2.draw3DRect(100+i*100, 100, 100, 100,true);
	}
	
	/*Ellipse2D elipse=new Ellipse2D.Double();
	elipse.setFrame(rectangulo);
	//g2.draw(rectangulo);
	g2.setPaint(Color.RED);
	g2.fill(rectangulo);
//	g2.draw(elipse);
	g2.setPaint(new Color(109,172,59));
	g2.fill(elipse);
	//g2.draw(new Line2D.Double(120,50,320,200));
	//double centroX=rectangulo.getCenterX();
	//double centroY=rectangulo.getCenterY();
	//double radio=125;
	//Ellipse2D circulo=new Ellipse2D.Double();
	//circulo.setFrameFromCenter(centroX, centroY, centroX+radio, centroY+radio);
	//g2.draw(circulo);
	 * */
	// Font mifuente=new Font("Courier",Font.BOLD,26);
	// g2.setFont(mifuente);
	// g2.setColor(Color.BLUE);
	 //g2.drawString("Adrian", 100, 100);
	// g2.setFont(new Font("Arial",Font.ITALIC,24));
	// g2.setColor(Color.RED.darker());
	 //g2.drawString("holaa", 100, 150);
	/*try {
		imagen=ImageIO.read(new File("esfera.jpg"));
	} catch (IOException e) {
		
		System.out.println("la imagen no se encuentra");
	}
	int anchuraImagen=imagen.getWidth(this);
	int alturaImagen=imagen.getHeight(this);
	
	g.drawImage(imagen, 0, 0, null);
	for(int i=0;i<300;i++) {
		for(int j=0;j<200;j++) {
				g.copyArea(0, 0,anchuraImagen, alturaImagen,i*anchuraImagen,j*alturaImagen);
		}
	}
	*/
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
	/*Image asd=null;
	try {
		asd = ImageIO.read(new File("./fondos/fondoJuego.jpg"));
	} catch (IOException e) {
		System.out.println("no se encuentra la imagen Tablero");

	}
	*/
}

}

