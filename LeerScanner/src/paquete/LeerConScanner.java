package paquete;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Locale;

public class LeerConScanner{

	/* este programa lee un archivo con el siguiente formato:
	   primera linea un entero n que indica la cantidad de numeros siguientes  que debo leer
	   seguido por  n numeros tipo  double
	   Ver mas ejemplos de Scanner en 
	   http://www.redeszone.net/2012/02/20/curso-de-java-entrada-y-salida-con-ficheros-clase-scanner/
    */

	public static void main(String[] args) throws FileNotFoundException  {
	
	    String miPath = "C:\\Users\\user\\Desktop\\";
		Scanner sc;
		File f = new File("C:\\Users\\user\\Desktop\\archivo.txt");
			sc = new Scanner(f);
			
		int [][] mat= new int[2][(int)f.length()/5]; // con f.legth obtengo los caracteres que tiene el archivo , por cada linea hay 5 caracteres
	
			
			for(int j=0;j<mat[0].length;j++) {
				for(int h=0;h<mat.length;h++) {
					
					mat[h][j]=sc.nextInt();
					
				}
			}
			//sc.useLocale(Locale.ENGLISH);
		System.out.println("fila:"+mat.length);
		System.out.println("columna:"+mat[0].length);
			
		for(int i=0;i<mat[0].length;i++) {
			for(int k=0;k<mat.length;k++) {
				
				System.out.print(mat[k][i]+"\t");
				
				
			}
			System.out.println();
		}
			
		
			sc.close();
	
		}
		



}