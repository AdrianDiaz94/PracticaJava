import javax.swing.JFrame;

public class PruebaDIbujo {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		MarcoConDibujos miVentana= new MarcoConDibujos("ventana1",50,200);
		MarcoConDibujos miVentana2= new MarcoConDibujos("ventana2",700,200);
		miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miVentana2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}


}
