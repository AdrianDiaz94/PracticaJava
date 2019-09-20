package paquete;

public class Matriz {
/*public void EscribirMatriz(int [][] matriz) {
 int j=matriz.length-1;
 for(int i=0;i<matriz.length;i++) {
	matriz[i][i]=1;
	matriz[i][j]=1;
	j--;
 }
}
*/
   public void escribirDiagonales(int [][] matriz) {
    	
    	int i,j;

    	for(i=0,j=matriz[0].length-1; i<matriz.length&&j>-1; i++,j--) { //Llena el diagonal secundario con 1.
    	       matriz[i][j]=1;
    	       matriz[i][i]=1;
    	}
    	MostrarMatriz(matriz);

	}
	
public void MostrarMatriz(int matriz[][]) {
		 for(int k=0;k<matriz.length;k++) {
				for(int h=0;h<matriz.length;h++)
					System.out.print(matriz[k][h]+"\t");
				System.out.println();
			}
	 }
	

}
