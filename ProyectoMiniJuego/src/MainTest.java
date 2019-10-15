import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

public class MainTest {
	public static void main(String[] args) {
	Jugador jugador1=new Jugador("dragon", "juan");
	Jugador jugador2=new Jugador("mago", "sergio");
	Jugador jugador3=new Jugador("orco", "adrian");
	Jugador jugador4=new Jugador("caballero", "pablo");
	List <Jugador>jugadores= new LinkedList<Jugador>();
	jugadores.add(jugador1);
	jugadores.add(jugador2);
	jugadores.add(jugador3);
	jugadores.add(jugador4);
	Minijuego mini= new Minijuego(jugadores);
	mini.ventana.panelDado.run();
	
	}

}
