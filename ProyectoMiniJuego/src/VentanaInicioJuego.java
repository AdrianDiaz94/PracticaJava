import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VentanaInicioJuego extends JFrame {
	PanelVentanaMiniJuego panelInicio;
	PanelDado panelDado;
	public VentanaInicioJuego(String titulo,int x , int y,Minijuego mini) {
		setLocation(x, y);
		setSize(950,400);
		setTitle(titulo);
		this.panelInicio=new PanelVentanaMiniJuego(mini);
		this.panelDado=new PanelDado();
		
		//add(panelInicio);
		add(panelDado);

		
		//visibilizarModalidad();
		
	
	}
	public  PanelVentanaMiniJuego getPanel() {
		return this.panelInicio;
	}

	
}
