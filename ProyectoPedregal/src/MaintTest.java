import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaintTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Apéndice de método generado automáticamente
		Scanner sc=new Scanner(new File ("pedregal.txt"));
		int columnas=sc.nextInt();
		int filas = sc.nextInt();
		int ancho=sc.nextInt();
		int largo=sc.nextInt();
		int cantidadPeñascos=sc.nextInt();
		int [][]matriz=new int[filas][columnas];
		int columna;
		int fila;
		int filaMenor=-1;
		int columnaMenor=-1;
		int cantidadSinPeñascos=0;
		int cantidadObjetivo=ancho*largo;
		int centroPuerta=ancho/2;
		String sentido="NO";
		for(int i=0;i<cantidadPeñascos;i++) {
			columna=sc.nextInt()-1;
			fila=sc.nextInt()-1;
			matriz[fila][columna]=1;
		}
		int i=0;
		int j;
		
		boolean puede=false;
		
		while(i<filas && puede == false) {
			j=0;
			while(j<columnas && puede==false) {
				
				
				for(int k=i;k<i+ancho && i+ancho-1<filas && puede == false;k++) {
					sentido=MaintTest.definirSentido(i, j, filas, columnas, centroPuerta, matriz, largo,"A");
					for(int h=j;h<j+largo && j+largo-1<columnas;h++) {
						if(matriz[k][h]==0)
							cantidadSinPeñascos++;
					}
					
				}
				if(cantidadSinPeñascos==cantidadObjetivo && sentido!="NO") {
					puede=true;
				}
				else {
					cantidadSinPeñascos=0;
				}
				
				for(int k=i;k<i+largo && i+largo-1<filas && puede == false;k++) {
					sentido=MaintTest.definirSentido(i, j, filas, columnas, centroPuerta, matriz, largo,"B");
					
					for(int h=j;h<j+ancho && j+ancho-1<columnas;h++) {
						if(matriz[k][h]==0)
							cantidadSinPeñascos++;
					}
					
				}
				if(cantidadSinPeñascos==cantidadObjetivo ) {
					filaMenor=i+1;
					columnaMenor=j+1;
					puede=true;
				}
				else {
					cantidadSinPeñascos=0;
				}
				
					
					j++;
					}
				
			i++;
			}
			
		
		if(puede==true) {
			System.out.println("fila menor: " +filaMenor+ " columna Menor: "+columnaMenor);
			System.out.println("sentido: " +sentido);
		}
		else
			System.out.println("no hay lugar");
		sc.close();
		

	}
	public static String definirSentido(int i, int j, int filas, int columnas,int centroPuerta,int matriz[][],int largo,String fase) {
		String sentido;
		if(fase=="A") {
			if(j>0 && i+centroPuerta<filas && matriz[i+centroPuerta][j-1]==0) {
				sentido="O";
			}
			else if(j==0) {
				sentido="O";
			}
			else if(j+largo<columnas && i+centroPuerta<filas && matriz[i+centroPuerta][j+largo]==0) {
				sentido="E";
			}
			else if (j+largo==columnas)
				sentido="E";
			else
				sentido="NO";
			}
		else {
			if(i>0 && j+centroPuerta<filas && matriz[i-1][j+centroPuerta]==0) {			
				sentido="S";
			}
			else if (i==0)
				sentido="S";
			else if(i+largo<filas && j+centroPuerta<columnas && matriz[i+largo][j+centroPuerta]==0) {
				sentido="N";
			}
			else if(i+largo==filas)
				sentido="N";
			else
				sentido="NO";
			
		}
		return sentido;
	}
	
}
