package paquete;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Locale;




public class Torneo {

	public static void main(String[] args) throws IOException  {
		File f = new File("archivo.txt");
		int cantidadDomina=0;
		Scanner	sc = new Scanner(f);
		PrintWriter salida= new PrintWriter(new FileWriter("salida.txt"));
		int cantidad=sc.nextInt();
		Luchador[] l =new Luchador[cantidad];
						
		for(int i=0;i<cantidad;i++){
			l[i]= new Luchador (sc.nextInt(),sc.nextInt()); // creo los objetos Luchador con sus valores 
		 }
	
		for (int j=0 ; j<cantidad ; j++){		
			for (int k=0 ; k<cantidad;k++){
				if (l[j].Domina(l[k]))
					cantidadDomina++;									
			}
			l[j].SetDomina(cantidadDomina);
			cantidadDomina=0;
		}
	
		for (int h=0 ; h<cantidad;h++) {
			salida.println(l[h].GetDomina()); //escribo en el archivo de salida
		}
		
		sc.close();
		salida.close();
	
	}
}
