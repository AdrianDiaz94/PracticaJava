import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MarcoConDibujos extends JFrame {
	public MarcoConDibujos(String titulo,int x, int y) {
		setVisible(true);
		setLocation(x,y);
		setSize(500, 500);
		setTitle(titulo);
		LaminaConFiguras miLamina=new LaminaConFiguras();
	
		add(miLamina);
		M_Ventana oyenteVenta = new M_Ventana();
		addWindowListener(oyenteVenta);
		
		//miLamina.setBackground(Color.BLACK);
		//miLamina.setBackground(SystemColor.window);
		//miLamina.setForeground(Color.BLUE);
	}
}
class M_Ventana implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente
		System.out.println("ventana abierta");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente
		
		System.out.println("cerrando ventana");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente
		System.out.println("ventana cerrada");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente
		System.out.println("se minimizo");
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente
		System.out.println("ventana restaurada");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente
		System.out.println("ventana Activada");
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Apéndice de método generado automáticamente
		System.out.println("ventana desactivada");
	}
	
}