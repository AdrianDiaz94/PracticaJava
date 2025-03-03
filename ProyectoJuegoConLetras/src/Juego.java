import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Juego {

	public static void buscarPalabras(String archivo) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(archivo));

		int dimension = sc.nextInt();
		int cantPalabras = sc.nextInt();
		String[] vectorEste = new String[dimension];
		String[] vectorOeste = new String[dimension];
		String[] vectorNorte = new String[dimension];
		String[] vectorSur = new String[dimension];
		String[] palabras = new String[cantPalabras];

		for (int i = 0; i < dimension; i++) {
			vectorEste[i] = sc.next();
			vectorSur[i] = "";
			vectorNorte[i] = "";
			vectorOeste[i] = "";
		}
		for(int i=0;i<cantPalabras;i++) {
			palabras[i]=sc.next();
		}

		for (int i = 0; i < dimension; i++) {
			String cadena = vectorEste[i];
			for (int j = dimension - 1; j > -1; j--) {
				vectorOeste[i] = vectorOeste[i] + cadena.charAt(j);
				vectorNorte[j] = cadena.charAt(j) + vectorNorte[j];
				vectorSur[dimension - j - 1] = vectorSur[dimension - j - 1] + cadena.charAt(j);
			}

		}
		boolean encontrada = false;
		PrintWriter salida= new PrintWriter("archivoSalida.txt");
		for (int j = 0; j < cantPalabras; j++) {
			int i = 0;
			while (i < dimension && encontrada == false) {
				int pos=j+1;
				if (vectorEste[i].contains(palabras[j])) {
					salida.println(pos+" "+"E");
					encontrada = true;
				}
				else if(vectorOeste[i].contains(palabras[j])) {
					salida.println(pos+" "+"O");
					encontrada = true;
				}
				else if(vectorNorte[i].contains(palabras[j])) {
					salida.println(pos+" "+"N");
					encontrada = true;
				}
				else if(vectorSur[i].contains(palabras[j])) {
					salida.println(pos+" "+"S");
				
					encontrada = true;
				}
				
				i++;
			}
			
				encontrada = false;
			

		}
		salida.close();

		sc.close();
	}
}
