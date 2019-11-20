
public class MainTest {

	public static void main(String[] args) {
	InspeccionandoReserva i= new InspeccionandoReserva("archivo2.txt");
	System.out.println(i.obtenerCantidadCaminos(new Nodo(0), new Nodo(9)));
	
	}

}
