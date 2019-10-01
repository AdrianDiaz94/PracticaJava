import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Piano {

	

 

	public static void buscarPosicionesOptimas(String fileInput, String fileOutput) throws FileNotFoundException {
		
		Scanner sc= new Scanner(new File(fileInput));
		PrintWriter salida= new PrintWriter(fileOutput);
		int cantidadNotas=sc.nextInt();
		int i=1;
		boolean puedePosicionAnteriorTecla2=true;
		boolean puedeTecla1Tecla2=true;
		boolean puedeTecla2Tecla1=true;
		boolean puedePosicionTecla2=true;
		boolean puedeAnteriorTecla1Tecla2=true;
		boolean puedeAnteriorTecla2Tecla1=true;
		boolean tecla1EsNegra=true;
		boolean tecla2EsNegra=true;
		
		Tecla tecla1=new Tecla("C1");
		Tecla tecla2=new Tecla("C1");
		Tecla posicionOptima =new Tecla("C1");
		if(cantidadNotas==1) {
			tecla1.setNota(sc.next());
			tecla1.setNota(tecla1.notaBlancaAnterior());
			salida.println(tecla1.getNota());			
		}
		else if(cantidadNotas>0) {
				tecla1.setNota(sc.next());		
				posicionOptima.setNota(tecla1.notaBlancaAnterior());
		}
		

		while(i<cantidadNotas) {
			
			tecla2.setNota(sc.next());			
			tecla1EsNegra=tecla1.getTipo().equals("negra");
			tecla2EsNegra=tecla1.getTipo().equals("negra");
			puedeTecla1Tecla2=tecla1.puedeTocar(tecla2);
			puedeTecla2Tecla1=tecla2.puedeTocar(tecla1);
			puedePosicionTecla2=posicionOptima.puedeTocar(tecla2);
			Tecla anteriorTecla1= new Tecla(tecla1.notaBlancaAnterior());
			Tecla anteriorTecla2= new Tecla(tecla2.notaBlancaAnterior());
			
			if( !puedeTecla1Tecla2 && !puedeTecla2Tecla1) {
			
					puedeAnteriorTecla2Tecla1=anteriorTecla2.puedeTocar(tecla1);
					puedeAnteriorTecla1Tecla2=anteriorTecla1.puedeTocar(tecla2);
					puedePosicionAnteriorTecla2=posicionOptima.puedeTocar(anteriorTecla2);
				
					if(tecla1EsNegra && tecla2EsNegra && puedeAnteriorTecla1Tecla2) {
							posicionOptima.setNota(anteriorTecla1.getNota());
							tecla1.setNota(tecla2.getNota());
					}
					else if(tecla1EsNegra && tecla2EsNegra && !puedeAnteriorTecla1Tecla2 && puedeAnteriorTecla2Tecla1) {
							if(!puedePosicionAnteriorTecla2)
								posicionOptima.setNota(anteriorTecla2.getNota());
					}
					
					else {
							salida.println(posicionOptima.getNota());
							tecla1.setNota(tecla2.getNota());
							posicionOptima.setNota(tecla2.getNota());					
					}			
			}
			else if(puedeTecla2Tecla1 && !puedeTecla1Tecla2 ) {
					if(!puedePosicionTecla2)
							posicionOptima.setNota(tecla2.getNota());
			}
			i++;
			if(i==cantidadNotas)
					salida.println(posicionOptima.notaBlancaAnterior());							
		}
		
		sc.close();
		salida.close(); 
	}
}