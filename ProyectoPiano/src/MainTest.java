import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc= new Scanner(new File("entrada.txt"));
		int cantidadNotas=sc.nextInt();
		int i=1;
		boolean puede=true;
		Tecla tecla1 = new Tecla(sc.next());
		while(i<cantidadNotas) {
			
			while(puede==true && i<cantidadNotas) {
				String nota=sc.next();
				Tecla tecla2 = new Tecla(nota);
				puede=tecla1.puedeTocar(tecla2);
				if(puede==false) {
					System.out.println(tecla1);
					tecla1.setLetra(tecla2.getLetra());
					
				}
				else
					i++;
			}
			puede=true;
			i++;
		}
		sc.close();
	}

}
