
public class QuickSort {

	
	public static void ordenar(int inicio, int fin, int vector[]) {
		if(inicio>=fin)
			return;
		int pibot=(inicio+fin)/2;
		int i=inicio;
		int j=fin-1;
		int aux=vector[pibot];
		vector[pibot]=vector[fin];
		vector[fin]=aux;
		pibot=fin;
		while(i<=j) {
			
			while(i<fin && vector[i]<vector[pibot]) 
				i++;
			
			while(j>=inicio && vector[j]>vector[pibot])
				j--;
			if(i<j) {
			aux=vector[i];
			vector[i]=vector[j];
			vector[j]=aux;
			i++;
			}
			j--;
						
		}
	
		aux=vector[pibot];
		vector[pibot]=vector[i];
		vector[i]=aux;
		
		ordenar(inicio, i-1, vector); // parte izquierda
		ordenar(i+1,fin,vector);// parte derecha
		
		
	}
}
