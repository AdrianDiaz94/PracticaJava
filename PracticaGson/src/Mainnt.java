import com.google.gson.*;

public class Mainnt {

	public static void main(String[] args) {
	
		Jugador jugador=new Jugador("pepe",100,0,1);
		
		Gson gson=new Gson();
		String mensaje=gson.toJson(jugador);
		
		System.out.println(mensaje);
		Jugador jugadorGson=gson.fromJson(mensaje, Jugador.class);
		
		System.out.println(jugadorGson);
	}

}
