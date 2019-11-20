import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Servidor {
	VentanaServidor ventana;
	public Servidor() {
		ventana=new VentanaServidor();
	}
}

class VentanaServidor extends JFrame{
	PanelServidor panel;
	public VentanaServidor() {
		panel=new PanelServidor();
		add(panel);
		setVisible(true);
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
}
class PanelServidor extends JPanel{
	JTextField texto;

	public PanelServidor() {
		//.setVisible(true);
	
		texto=new JTextField(20);
		texto.setLocation(30, 30);
		add(texto);
		
	}
	
	public void paintComponent(Graphics g) {
	//	texto.setLocation(150, 150);
		super.paintComponent(g);
	}
}