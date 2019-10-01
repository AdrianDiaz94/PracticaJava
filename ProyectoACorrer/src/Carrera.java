import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carrera {
	
public void obtenerGanadores(String fileIn,String fileOut) throws FileNotFoundException {
	Scanner sc=new Scanner(new File(fileIn));
	int cantidadCorredores=sc.nextInt();
	Corredor [] corredoresInscriptos=new Corredor[cantidadCorredores];
	int categoriasFemeninas=sc.nextInt();
	int categoriasMasculinas=sc.nextInt();
	int cantidadLLegaron=sc.nextInt();
	int [] categorias= new int [(categoriasFemeninas+categoriasMasculinas)*2];
	int [][] podio= new int [categoriasMasculinas+categoriasFemeninas] [4];
	int i=0;
	while(i<(categoriasFemeninas+categoriasMasculinas)*2) {
		categorias[i]=sc.nextInt();
		i++;
	}
	i=0;

	while(i<cantidadCorredores) {
		corredoresInscriptos[i] = new Corredor(sc.nextInt(),sc.next());
		i++;
	}
	for(int j=0;j<cantidadLLegaron;j++) {
		int numCorredor=sc.nextInt();
		Corredor corredor=new Corredor();
		corredor=corredoresInscriptos[numCorredor-1];
		boolean rangoEncontrado=false;
		
		int lugar=0;
		if(corredor.getSexo().equals("M"))
			lugar=categoriasFemeninas*2;
		while(rangoEncontrado==false) {
			if(corredor.getEdad() >= categorias[lugar] && corredor.getEdad()<= categorias[lugar+1])
				rangoEncontrado=true;
			if(rangoEncontrado==false)
			lugar+=2;
		}
		
		
				
	}
	sc.close();
	
}
}
