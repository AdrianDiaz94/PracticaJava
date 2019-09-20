package paquete;

public class MainTest {

/*	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
		Vector vec = new Vector();
		Integer [] vector= {2,3,4,2};
		System.out.println(Vector.buscarPico(vector));

	}
	*/
	public static void main(String[] args) {
		int [] arreglo  = {8, 7, 6, 5, 4, 3};
		int i = 0;
		while(arreglo[i] < arreglo[i+1])
			i++;
		System.out.println("la posicion es: " + i);
	}

}
