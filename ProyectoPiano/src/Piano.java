import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import java.util.Scanner;

import javax.management.Query;

public class Piano {

	public static void buscarPosicionesOptimas(String fileInput, String fileOutput) throws FileNotFoundException {
		
		Scanner sc= new Scanner(new File(fileInput));
		int cantidadNotas=sc.nextInt();
		int i=1;
		boolean puedeTecla1Tecla2=true;
		boolean puedeTecla2Tecla1=true;
		boolean puedePosicionTecla2=true;
		boolean puedeTecla2Posicion=true;
		List <Tecla> posicionesOptimas= new LinkedList<Tecla>();
		Tecla tecla1=new Tecla("nada");
		Tecla tecla2=new Tecla("nada");
		Tecla posicionOptima =new Tecla("nada");
		if(cantidadNotas==1) {
			posicionesOptimas.add(new Tecla(sc.next()));	
		}
		else if(cantidadNotas>0) {
		 tecla1.setNota(sc.next());
		 posicionOptima.setNota(tecla1.getNota());
		}
		
		
		while(i<cantidadNotas) {
			tecla2.setNota(sc.next());
			i++;
			puedeTecla1Tecla2=tecla1.puedeTocar(tecla2);
			puedeTecla2Tecla1=tecla2.puedeTocar(tecla1);
			if(puedeTecla1Tecla2==true && puedeTecla2Tecla1==false) {
				puedePosicionTecla2=posicionOptima.puedeTocar(tecla2);
				if(puedePosicionTecla2==false) {
					tecla1.setNota(tecla2.getNota());
					posicionesOptimas.add(new Tecla(posicionOptima.getNota()));
					posicionOptima.setNota(tecla1.getNota());
				}
					
			}
			else if(puedeTecla1Tecla2==false && puedeTecla2Tecla1==true) {
				
				puedeTecla2Posicion=tecla2.puedeTocar(posicionOptima);
				if(puedeTecla2Posicion==true) {
					posicionOptima.setNota(tecla2.getNota());
				}
			}
			else if(puedeTecla1Tecla2==true && puedeTecla2Tecla1==true) {
				posicionOptima.setNota(tecla1.getNota());
			}
			else {
				posicionesOptimas.add(new Tecla(posicionOptima.getNota()));				
				tecla1.setNota(tecla2.getNota());	
				posicionOptima.setNota(tecla1.getNota());
			}
			if(i==cantidadNotas)
				posicionesOptimas.add(new Tecla(posicionOptima.getNota()));	
			
		}
		
		PrintWriter salida= new PrintWriter(fileOutput);
		for (Tecla tecla : posicionesOptimas) {
			salida.println(tecla.getNota());
		}
		sc.close();
		salida.close();
		
	}
}

