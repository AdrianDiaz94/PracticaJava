
public class MainTest {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		Bicicleta bici= new Bicicleta();
		Colectivo bondi=new Colectivo(20);
		Avion avi=new Avion(20);
		bici.agregarConductor();
		
		bici.moverse();
		bici.detenerse();
		bici.agregarPasajeros(1);
		bondi.agregarConductor();
		bondi.moverse();
		bondi.detenerse();
		bondi.agregarPasajeros(10);
		//avi.agregarConductor();
		avi.agregarPasajeros(2);
		avi.moverse();
		avi.despegar();
		avi.aterrizar();
		avi.detenerse();

	}

}
