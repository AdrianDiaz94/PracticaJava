import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaintTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Apéndice de método generado automáticamente
		Scanner sc = new Scanner(new File("baldosas.txt"));
		
			String baldosas=sc.next();
			
			int indexColor=baldosas.indexOf('A');
			//Busco la posicion de la baldosa pintada
			if(indexColor == -1) {
				indexColor=baldosas.indexOf('V');
				if(indexColor== -1) {
				indexColor=baldosas.indexOf('R');
				if(indexColor==-1) {
					System.out.println("no hay ningun color en ninguna baldosa");
					return ;
					
				}
					
				}
			}
		     System.out.println("index del color: " + indexColor  );
		     System.out.println("color encontrado: "+baldosas.charAt(indexColor));
				for ( int i=indexColor ;i< baldosas.length()-1;i++) {
					char colorN=elegirColorSiguiente(baldosas.charAt(i));
				baldosas=baldosas.substring(0, i+1)+colorN+baldosas.substring(i+2, baldosas.length());
				
				}
				for ( int i=indexColor ;i>0;i--) {
					char colorN=elegirColorAnterior(baldosas.charAt(i));
					baldosas=baldosas.substring(0, i-1)+colorN+baldosas.substring(i, baldosas.length());
				
				}
				
			System.out.println(baldosas);
			
			sc.close();
			
		
	}
public static char elegirColorSiguiente(char color) {
	//A R V
	
	if(color=='A')
		return 'R';
	else if(color=='R')
		return 'V';
	else
		return 'A';
		
	
}
public static char elegirColorAnterior(char color) {
	//A R V
	
	if(color=='A')
		return 'V';
	else if(color=='R')
		return 'A';
	else
		return 'R';
		
	
}
}
