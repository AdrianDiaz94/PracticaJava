
public class Insercion {
public static void ordenar(int vec[]) {
	
	
	for(int i=1;i<vec.length;i++) {
		int j=i-1;
		int aux;
		int h=i;
		while(j>=0 && vec[j]>vec[h]) {
			aux=vec[h];
			vec[h]=vec[j];
			vec[j]=aux;
			j--;
			h--;
		}
		
	}

}
}
