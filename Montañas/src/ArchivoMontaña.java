import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArchivoMontaña {
	
	public static Montaña abrirArchivo(String path) throws FileNotFoundException {
		int posXCarrito = 0; 
		Scanner archivoLec = new Scanner(new File(path));
		int cant = archivoLec.nextInt();
		int[] cimaYvalle = new int [cant]; 
		
		for (int i = 0; i < cimaYvalle.length ; i++) {
			cimaYvalle[i] = archivoLec.nextInt(); //Guardo cimas y valles
		}
		posXCarrito = archivoLec.nextInt(); //Posicion en X del carrito
		
		archivoLec.close();
		return new Montaña(cant, cimaYvalle, posXCarrito);
	}
	
}
