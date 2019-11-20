import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cliente {
	VentanaCliente ventana;
	public Cliente() {
		ventana=new VentanaCliente();
	}

}
class VentanaCliente extends JFrame{
	PanelCliente panel;
	public VentanaCliente() {
		panel=new PanelCliente();
		add(panel);
		setVisible(true);
		
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
class PanelCliente extends JPanel{
	
	JTextArea chat;
	JTextField mensaje;
	public PanelCliente() {
		chat=new JTextArea(20, 70);
		mensaje= new JTextField(50);
		chat.setLocation(40,40);
		add(chat);
		mensaje.setLocation(300, 100);
		add(mensaje);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
}