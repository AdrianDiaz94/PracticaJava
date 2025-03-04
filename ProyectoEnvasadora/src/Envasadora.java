import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Envasadora {

	public static void procesar(String archivo) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(archivo));
		String cadena = sc.next();
		int maximo = 0;
		int maximoAnterior = 0;
		int posMaximo = 0;
		int posMaximoAnterior = 0;
		int cantidad = 0;
		int distancia = 0;
		int i = 0;
		
		while (!cadena.substring(i, i + 1).equals("F")) {

			if (cadena.substring(i, i + 1).equals("G")) {
				cantidad++;
			} else if (cantidad > maximo) {
				maximoAnterior = maximo;
				posMaximoAnterior = posMaximo;
				posMaximo = i - 1;
				maximo = cantidad;
				cantidad = 0;
			} else if (cantidad > maximoAnterior) {
				maximoAnterior = cantidad;
				posMaximoAnterior = i - 1;
				cantidad = 0;
			} else {
				cantidad = 0;

			}

			i++;
		}

		sc.close();

		if (posMaximo > posMaximoAnterior) {
			distancia = posMaximo - maximo - posMaximoAnterior;
		} else {
			distancia = posMaximoAnterior - posMaximo - maximoAnterior;
		}
		PrintWriter salida= new PrintWriter("salida.txt");
		salida.println(i);
		salida.println(maximo);
		salida.println(maximoAnterior);
		salida.println(distancia);
		salida.close();

	}
}
